package com.example.obsinqsob01.dolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.obsinqsob01.dolist.models.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.task_card.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tasks = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fill the tasks array with static data
        (1..3).map {
            tasks.add(Task(it, "Tarea $it", "Description for $it", Date()))
        }

        list_view_tasks.adapter = TaskAdapter(tasks)

        // Click listener to add a new task
        btn_add_task.setOnClickListener {
            val intent = Intent(applicationContext, AddTaskActivity::class.java)

            startActivity(intent)
        }
    }

    inner class TaskAdapter : BaseAdapter {
        var tasks = ArrayList<Task>()
        constructor(tasks: ArrayList<Task>) : super() {
            this.tasks = tasks
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var task_layout = layoutInflater.inflate(R.layout.task_card, null)
            var task = getItem(position)

            task_layout.text_title.text = task.title
            task_layout.text_description.text = task.description
            task_layout.text_hour.text = "${task.hour.hours}:${task.hour.minutes}"

            task_layout.setOnClickListener {
                val intent = Intent(applicationContext, TaskViewActivity::class.java)

                intent.putExtra("task", task)

                startActivity(intent)
            }

            return task_layout
        }

        override fun getItem(position: Int): Task {
            return this.tasks[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return tasks.count()
        }

    }
}
