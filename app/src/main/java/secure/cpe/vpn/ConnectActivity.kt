package secure.cpe.vpn

import android.annotation.SuppressLint
import android.content.Intent
import android.net.VpnService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import de.blinkt.openvpn.OpenVpnApi
import de.blinkt.openvpn.core.OpenVPNService
import de.blinkt.openvpn.core.OpenVPNThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import secure.cpe.vpn.databinding.ActivityConnectBinding
import java.util.Date
import kotlin.random.Random

class ConnectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConnectBinding

    private var isConnected = false
    private var generator: Job? = null
    private var random = Random(Date().time)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initInterface()
        initMenu()
        initDisconnectLayout()
    }

    private fun initInterface(){
        binding.apply {

            serversBtn.setOnClickListener{
                if (countriesLayout.visibility == View.GONE){
                    openSelector()
                }else{
                    closeSelector()
                }
            }

            btnFirstBg.setOnClickListener {
                if (isConnected){
                    disconnectLayout.visibility = View.VISIBLE
                }else{
                    connectVPN()
                }
            }

            premiumTopBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, PayActivity::class.java))
            }

            countriesRecycler.layoutManager = LinearLayoutManager(this@ConnectActivity, LinearLayoutManager.VERTICAL, false)


        }
    }

    override fun onResume() {
        super.onResume()
        setLastActivity()
        setSelectedServerUI()
        setVpnListeners()
        setStatus(OpenVPNService.getStatus())
    }

    private fun connectVPN(){
        val intent = VpnService.prepare(this)
        if (intent != null) {
            vpnResultLauncher.launch(intent)
        } else {
            try {
                val server = Config.getSelectedServer(this)
                OpenVpnApi.startVpn(this, server.ovpn, server.name, "", "")
            } catch (_: Exception) {}
        }
    }

    private var vpnResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                connectVPN()
            }
        }

    private fun disconnectVPN(){
        try {
            OpenVPNThread.stop()
            isConnected = false
        }catch (_: Exception){}
    }

    private fun setStatus(state: String){
        runOnUiThread {
            when (state) {
                "VPN_GENERATE_CONFIG" -> {
                    setConnecting()
                }
                "CONNECTED" -> {
                    setConnected()
                }
                "DISCONNECTED" -> {
                    setDisconnected()
                }
                "NONETWORK" -> {
                    disconnectVPN()
                    setDisconnected()
                }
            }
        }
    }

    private fun setVpnListeners(){

        OpenVPNService.addOnStateChangeListener { state ->
            setStatus(state)
        }

        OpenVPNService.addOnDetailChangeListener{stateData ->
            val (duration, byteIn, byteOut) = stateData
            runOnUiThread{
                binding.timeText.text = duration
                var array = byteIn.split(" ")
                if (array.size >= 2){
                    binding.downloadText.text = array[0]
                }
                array = byteOut.split(" ")
                if (array.size >= 2){
                    binding.uploadText.text = array[0]
                }
            }
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    private fun setConnected(){
        isConnected = true
        Config.setLast(this, Config.getSelectedServer(this))
        binding.apply {
            btnFirstBg.setCardBackgroundColor(getColor(R.color.connect_1))
            btnSecondBg.setCardBackgroundColor(getColor(R.color.connect_2))
            btnImage.setImageDrawable(getDrawable(R.drawable.on_btn))
            btnText.text = "Connected"
            btnAddress.visibility = View.VISIBLE
            pingGenerator()
        }
    }


    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    private fun setConnecting(){
        binding.apply {
            btnFirstBg.setCardBackgroundColor(getColor(R.color.no_connect_1))
            btnSecondBg.setCardBackgroundColor(getColor(R.color.no_connect_2))
            btnImage.setImageDrawable(getDrawable(R.drawable.on_btn))
            btnText.text = "Connecting"
            btnAddress.visibility = View.GONE
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    private fun setDisconnected(){
        generator?.cancel()
        binding.apply {
            btnFirstBg.setCardBackgroundColor(getColor(R.color.no_connect_1))
            btnSecondBg.setCardBackgroundColor(getColor(R.color.no_connect_2))
            btnImage.setImageDrawable(getDrawable(R.drawable.offbtn))
            btnText.text = "Disabled"
            btnAddress.visibility = View.GONE
            downloadText.text = ""
            uploadText.text = ""
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setLastActivity(){
        val last = Config.getLast(this)
        binding.apply {
            lastFlag.setImageDrawable(getDrawable(last.flag))
            lastSpeed.setImageDrawable(getDrawable(Config.generateSpeed()))
            lastIp.text = last.ip
            lastName.text = last.name
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setSelectedServerUI(){
        setLastActivity()
        val server = Config.getSelectedServer(this)
        binding.apply {
            serverImage.setImageDrawable(getDrawable(server.flag))
            serverName.text = server.name
            btnAddress.text = server.ip
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun openSelector(){

        binding.apply {

            countriesRecycler.adapter = ServerAdapter(this@ConnectActivity, Config.serverList)
            countriesBox.visibility = View.VISIBLE
            countriesLayout.visibility = View.VISIBLE
            lessMoreBtn.setImageDrawable(getDrawable(R.drawable.less))

        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun closeSelector(){

        binding.apply {

            countriesBox.visibility = View.GONE
            countriesLayout.visibility = View.GONE
            lessMoreBtn.setImageDrawable(getDrawable(R.drawable.more))

        }

    }

    fun setSelectedServer(server: ServerModel){
        Config.setSelectedServer(this, server)
        closeSelector()
        setSelectedServerUI()
        disconnectVPN()
    }

    private fun initDisconnectLayout(){
        binding.apply {
            disconnectAgree.setOnClickListener {
                disconnectLayout.visibility = View.GONE
                disconnectVPN()
            }

            disconnectCancel.setOnClickListener {
                disconnectLayout.visibility = View.GONE
            }
        }
    }

    private fun initMenu(){

        binding.apply {

            menuBtn.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }

            premiumBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, PayActivity::class.java))
            }

            termsBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, UtilsActivity::class.java).putExtra(UtilsActivity.INTENT_NAME, UtilsActivity.TERMS_OF_SERVICE))
            }

            privacyBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, UtilsActivity::class.java).putExtra(UtilsActivity.INTENT_NAME, UtilsActivity.PRIVACY_POLICY))
            }

            feedbackBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, UtilsActivity::class.java).putExtra(UtilsActivity.INTENT_NAME, UtilsActivity.FEEDBACK))
            }

            shareBtn.setOnClickListener {
                startActivity(Intent(this@ConnectActivity, UtilsActivity::class.java).putExtra(UtilsActivity.INTENT_NAME, UtilsActivity.SHARE))
            }

        }

    }

    private fun pingGenerator(){
        generator?.cancel()
        generator = CoroutineScope(Dispatchers.IO).launch {
            while (true){
                if (isDestroyed){
                    break
                }
                runOnUiThread {
                    binding.serverPing.text = "${random.nextInt(200)}"
                }
                delay(1000)
            }
        }
    }

    override fun onDestroy() {
        generator?.cancel()
        super.onDestroy()
    }

}