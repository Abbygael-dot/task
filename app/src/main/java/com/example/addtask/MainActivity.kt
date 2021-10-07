package com.example.addtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addtask.model.Taskmodel
import com.example.addtaskapp.adapter.taskadapter

class MainActivity : AppCompatActivity() {

    private var recyclerViewTask = " "
    private var myAdapter: taskadapter = taskadapter(this, mutableListOf())

    companion object{
        const val TAG = "MainActivity"
        const val KEY_RECYCVIEW = "recycler_ViewTask_key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        if (savedInstanceState != null){
            recyclerViewTask = savedInstanceState.getString(KEY_RECYCVIEW, " ")
        }
        setContentView(R.layout.activity_main)


        val editField : TextView = findViewById(R.id.edit_text)
        val addIcon : View = findViewById(R.id.icon)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_viewTask)

        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)


        addIcon.setOnClickListener {
            val newTaskTitle = editField.text.toString()
            if(newTaskTitle.isNotEmpty()){
                val newtask = Taskmodel(newTaskTitle)
                recyclerViewTask = myAdapter.addTask(newtask).toString()
                editField.text = " "
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d( TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d( TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d( TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d( TAG, "onStop Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_RECYCVIEW, recyclerViewTask)
        Log.d( TAG, "onSaveInstance Called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( TAG, "onRestart Called")
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(KEY_RECYCVIEW, recyclerViewTask)
//        Log.d( TAG, "onSaveInstance Called")
//
//    }


}

