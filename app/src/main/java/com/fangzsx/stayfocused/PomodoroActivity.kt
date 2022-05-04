package com.fangzsx.stayfocused

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.fangzsx.stayfocused.databinding.ActivityPomodoroBinding

class PomodoroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPomodoroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPomodoroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivTimer.setOnLongClickListener {

            val parent = it.parent as LinearLayout
            val timerParentName = parent.tag.toString()
            val clipDataItem


            true

        }



    }

}