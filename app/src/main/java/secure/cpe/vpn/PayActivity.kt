package secure.cpe.vpn

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import secure.cpe.vpn.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initInterface()
    }

    private fun initInterface(){

        binding.apply {

            weekBtn.setOnClickListener {
                setWeekSelect()
            }

            monthBtn.setOnClickListener {
                setMonthSelect()
            }

            yearBtn.setOnClickListener {
                setYearSelect()
            }

            backBtn.setOnClickListener {
                finish()
            }

            disconnectAgree.setOnClickListener {
                Toast.makeText(this@PayActivity, "Success", Toast.LENGTH_SHORT).show()
            }
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setWeekSelect(){
        binding.apply {

            weekBtn.setCardBackgroundColor(getColor(R.color.pay_select))
            weekImage.setImageDrawable(getDrawable(R.drawable.select))

            monthBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            monthImage.setImageDrawable(getDrawable(R.drawable.no_select))

            yearBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            yearImage.setImageDrawable(getDrawable(R.drawable.no_select))

        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setMonthSelect(){
        binding.apply {

            weekBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            weekImage.setImageDrawable(getDrawable(R.drawable.no_select))

            monthBtn.setCardBackgroundColor(getColor(R.color.pay_select))
            monthImage.setImageDrawable(getDrawable(R.drawable.select))

            yearBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            yearImage.setImageDrawable(getDrawable(R.drawable.no_select))

        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setYearSelect(){
        binding.apply {

            weekBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            weekImage.setImageDrawable(getDrawable(R.drawable.no_select))

            monthBtn.setCardBackgroundColor(getColor(R.color.pay_no_select))
            monthImage.setImageDrawable(getDrawable(R.drawable.no_select))

            yearBtn.setCardBackgroundColor(getColor(R.color.pay_select))
            yearImage.setImageDrawable(getDrawable(R.drawable.select))

        }
    }

}