package com.fangzsx.stayfocused

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import com.fangzsx.stayfocused.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val checkBoxGroup = mutableListOf<CheckBox>().apply {
            addAll(
                arrayOf(
                    binding.cbPalette1,
                    binding.cbPalette2,
                    binding.cbPalette3,
                    binding.cbPalette4,
                )
            )
        }
        

        for (checkbox in checkBoxGroup){
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    checkBoxGroup.filter { it.id != checkbox.id }.forEach { other ->
                        other.isChecked = false
                    }
                }
            }
        }




    }
}