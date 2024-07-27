package secure.cpe.vpn

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import secure.cpe.vpn.databinding.ActivityUtilsBinding

class UtilsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUtilsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtilsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initInterface()
    }

    @SuppressLint("SetTextI18n")
    private fun initInterface(){

        val flag = intent.getIntExtra(INTENT_NAME, 0)

        binding.apply {
            backbtn.setOnClickListener {
                finish()
            }
        }

        if (flag == PRIVACY_POLICY){
            binding.titleText.text = "Privacy Policy"
            supportFragmentManager.beginTransaction().replace(R.id.fragmentDisplay, PrivacyPolicyFragment()).commitAllowingStateLoss()
        }else if (flag == TERMS_OF_SERVICE){
            binding.titleText.text = "Term of Service"
            supportFragmentManager.beginTransaction().replace(R.id.fragmentDisplay, TermsOfServiceFragment()).commitAllowingStateLoss()
        }else if (flag == FEEDBACK){
            binding.titleText.text = "Submit Feedback"
            supportFragmentManager.beginTransaction().replace(R.id.fragmentDisplay, FeedbackFragment()).commitAllowingStateLoss()
        }else if (flag == SHARE){
            binding.titleText.text = "Share"
            supportFragmentManager.beginTransaction().replace(R.id.fragmentDisplay, ShareFragment()).commitAllowingStateLoss()
        }

    }

    companion object {
        const val INTENT_NAME = "FLAG"
        const val PRIVACY_POLICY = 0
        const val TERMS_OF_SERVICE = 1
        const val FEEDBACK = 2
        const val SHARE = 3
    }


}