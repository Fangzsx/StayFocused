package com.fangzsx.stayfocused

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
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

            //save current parent position using tags
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

        val dragListener = View.OnDragListener { view, event ->

            when(event.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val fromParentName = item.text
                    view.invalidate()

                    val dragView = event.localState as View
                    val owner = dragView.parent as ViewGroup
                    owner.removeView(dragView)

                    val destination = view as LinearLayout
                    destination.addView(dragView)
                    dragView.visibility = View.VISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                else -> false
            }
        }

        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)
        binding.llLeft.setOnDragListener(dragListener)
        binding.llCenter.setOnDragListener(dragListener)
        binding.llRight.setOnDragListener(dragListener)



    }

}