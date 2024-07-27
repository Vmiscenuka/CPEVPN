package secure.cpe.vpn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import secure.cpe.vpn.databinding.FragmentFeedbackBinding


class FeedbackFragment : Fragment() {

    private lateinit var binding: FragmentFeedbackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInterface()
    }

    private fun initInterface(){
        binding.apply {

            submitBtn.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Thanks for the feedback!",
                    Toast.LENGTH_SHORT
                ).show()

                subjectText.setText("")
                emailText.setText("")
                descriptionText.setText("")
            }

        }
    }

}