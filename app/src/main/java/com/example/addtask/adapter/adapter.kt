package com.example.addtaskapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addtask.MainActivity
import com.example.addtask.R
import com.example.addtask.model.Taskmodel


class taskadapter(private val context: MainActivity, private val task: MutableList<Taskmodel>):
    RecyclerView.Adapter<taskadapter.TaskViewHolder>() {

    class TaskViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val addedText: TextView = view.findViewById(R.id.toDoTask)
        val checkbox: CheckBox = view.findViewById(R.id.task_checkbox)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tasklayout, parent, false)
        )
    }

    fun addTask (new : Taskmodel){
        task.add(new)
        notifyItemInserted(task.size-1)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = task[position]
        holder.addedText.text = currentTask.newTask
        holder.checkbox.isChecked = currentTask.isChecked

    }

    override fun getItemCount(): Int {
        return task.size
    }
}


