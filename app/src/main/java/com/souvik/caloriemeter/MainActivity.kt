package com.souvik.caloriemeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.souvik.caloriemeter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var totalCal : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        initView()
    }

    private fun initView() {
        supportActionBar?.hide()
        binding.btnBurnCalory.setOnClickListener{
            totalCal+=(2..7).random()
            if(totalCal<=300){
                binding.customCal.changeBarColor(totalCal/30)
                binding.tvCalTxt.text = "${totalCal} Kcal"
            }else{
                binding.tvCalTxt.text = "300 Kcal"
                binding.customCal.changeBarColor(10)
                binding.btnBurnCalory.isEnabled = false
            }
        }
        binding.btnReset.setOnClickListener {
            totalCal = 0
            binding.customCal.changeBarColor(0)
            binding.tvCalTxt.text = "${totalCal} Kcal"
        }
    }
}