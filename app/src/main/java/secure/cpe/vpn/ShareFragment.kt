package secure.cpe.vpn

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import secure.cpe.vpn.databinding.FragmentShareBinding


class ShareFragment : Fragment() {

    private lateinit var binding: FragmentShareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShareBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInterface()
    }

    private fun initInterface(){

        binding.apply {

            facebookBtn.setOnClickListener {
                share()
            }

            twitterBtn.setOnClickListener {
                share()
            }

            whatsappBtn.setOnClickListener {
                share()
            }

            telegrambtn.setOnClickListener {
                share()
            }

        }

    }

    private fun share(){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Secure your network with CPE VPN!\nDownload: https://play.google.com/store/apps/details?id=${requireActivity().applicationContext.packageName}")

        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}