package com.example.obsinqsob01.dolist

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        btn_select_time.setOnClickListener {
            val timePicker = TimePickerFragment()

            timePicker.show(fragmentManager, "Time Picker")
        }
    }
}
