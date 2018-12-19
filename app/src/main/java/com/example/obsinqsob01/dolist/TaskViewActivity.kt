package com.example.obsinqsob01.dolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.obsinqsob01.dolist.models.Task
import kotlinx.android.synthetic.main.activity_task_view.*

class TaskViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_view)

        val task = intent.extras.getSerializable("task") as? Task

        task_title.text = task!!.title
        task_description.text = task.description
    }
}
