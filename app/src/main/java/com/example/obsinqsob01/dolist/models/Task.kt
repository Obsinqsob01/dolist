package com.example.obsinqsob01.dolist.models

import java.io.Serializable
import java.util.*

data class Task(val id: Int,var title: String, var description: String, var hour: Date) : Serializable
