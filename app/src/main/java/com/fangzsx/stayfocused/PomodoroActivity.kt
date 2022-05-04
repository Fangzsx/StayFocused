package com.fangzsx.stayfocused

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
            val item = ClipData.Item(timerParentName)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(timerParentName, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true

        }



    }

}