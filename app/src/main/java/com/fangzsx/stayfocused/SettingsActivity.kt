package com.fangzsx.stayfocused

import android.content.res.ColorStateList
import android.graphics.Color
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

        selectPalette()
        selectTimerStyle()


    }

    private fun selectTimerStyle() {
        val checkBoxGroup = mutableListOf<CheckBox>().apply {
            addAll(
                arrayOf(
                    binding.cbCircleStyle,
                    binding.cbCirclePixel,
                    binding.cbBorderless,
                    binding.cbBoxedStyle,
                )
            )
        }

        for (checkbox in checkBoxGroup) {
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkbox.buttonTintList = ColorStateList.valueOf(Color.parseColor("#63C132"))
                    checkBoxGroup.filter { it.id != checkbox.id }.forEach { other ->
                        other.buttonTintList = ColorStateList.valueOf(Color.parseColor("#BFB5B5"))
                        other.isChecked = false
                    }
                }
            }
        }
    }

    private fun selectPalette() {
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

        for (checkbox in checkBoxGroup) {
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkbox.buttonTintList = ColorStateList.valueOf(Color.parseColor("#63C132"))
                    checkBoxGroup.filter { it.id != checkbox.id }.forEach { other ->
                        other.buttonTintList = ColorStateList.valueOf(Color.parseColor("#BFB5B5"))
                        other.isChecked = false
                    }
                }
            }
        }
    }
}