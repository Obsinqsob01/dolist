package com.example.obsinqsob01.dolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.obsinqsob01.dolist.models.Task
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var tasks = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fill the tasks array with static data
        (1..10).map {
            tasks.add(Task(it, "Tarea $it", "Description for $it", Date()))
        }

        // Click listener to add a new task
        btn_add_task.setOnClickListener {view ->
            Snackbar.make(view, R.string.text_add_task, Snackbar.LENGTH_LONG)
                .setAction("Action", ({
                    Toast.makeText(applicationContext, R.string.text_add_task, Toast.LENGTH_SHORT)
                        .show()
                })).show()
        }
    }

    inner class TaskAdapter : BaseAdapter {
        var tasks = ArrayList<Task>()
        constructor(tasks: ArrayList<Task>) : super() {
            this.tasks = tasks
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            // somthins
        }

        override fun getItem(position: Int): Any {
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
