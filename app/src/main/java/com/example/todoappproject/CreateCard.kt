package com.example.todoappproject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.active_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.active_create_card)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java,"To_Do"
        ).build()
        save_button.setOnClickListener {
            if(create_title.text.toString().trim { it<=' '}.isNotEmpty()
                && create_priority.text.toString().trim { it<=' '}.isNotEmpty()
                && create_time.text.toString().trim { it<=' '}.isNotEmpty()
                && create_list.text.toString().trim { it<=' '}.isNotEmpty())
            {
                var title=create_title.getText().toString()
                var priority=create_priority.getText().toString()
                var time=create_time.getText().toString()
                var list=create_list.getText().toString()
                DataObject.setData(time, priority, time, list)
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title, priority, time, list))
                }
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}