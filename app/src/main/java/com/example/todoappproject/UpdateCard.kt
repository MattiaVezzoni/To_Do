package com.example.todoappproject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.active_create_card.create_list
import kotlinx.android.synthetic.main.active_create_card.create_priority
import kotlinx.android.synthetic.main.active_create_card.create_time
import kotlinx.android.synthetic.main.active_create_card.create_title
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_update_card)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java,"To_Do"
        ).build()
        val pos=intent.getIntExtra("id", -1)
        if(pos!=-1)
        {
            val title=DataObject.getData(pos).title
            val priority=DataObject.getData(pos).priority
            val time=DataObject.getData(pos).time
            val list=DataObject.getData(pos).list
            create_title.setText(title)
            create_priority.setText(priority)
            create_time.setText(time)
            create_list.setText(list)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entity(pos+1, create_title.text.toString(),
                        create_priority.text.toString(),
                        create_time.text.toString(),
                        create_list.text.toString())
                    )
                }
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateData(pos,
                    create_title.text.toString(),
                    create_priority.text.toString(),
                    create_time.text.toString(),
                    create_list.text.toString())
                GlobalScope.launch {
                    database.dao().updateTask(
                        Entity(pos+1, create_title.text.toString(),
                        create_priority.text.toString(),
                        create_time.text.toString(),
                        create_list.text.toString())
                    )
                }
                myIntent()
            }
        }
    }
    fun myIntent(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
