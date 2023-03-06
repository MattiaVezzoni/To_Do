package com.example.todoappproject

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var data:List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title=itemView.title
        var priority=itemView.priority
        var time=itemView.time
        var list=itemView.list
        var layout=itemView.mylayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView=LayoutInflater.from(parent.context).
                inflate(R.layout.view,parent,false)
        return viewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when(data[position].priority.toLowerCase())
        {
            "high"->holder.layout.setBackgroundColor(Color.parseColor("#ffcc0000"))
            "medium"->holder.layout.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
            else->holder.layout.setBackgroundColor(Color.parseColor("#FF4CAF50"))
        }

        fun onTimeViewHolder(holder: viewHolder, position: Int) {
            when(data[position].time.toLowerCase())
            {
                "1"->holder.time.setHintTextColor(Color.parseColor("FF020202"))
                "2"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "3"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "4"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "5"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "6"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "7"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "8"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "9"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "10"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "11"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "12"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "13"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "14"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "15"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "16"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "17"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "18"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "19"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                "20"->holder.time.setHintTextColor(Color.parseColor("#FF020202"))
                else->holder.time.setHintTextColor(Color.parseColor("#FF6E0000"))
            }

        holder.title.text=data[position].title
        holder.priority.text=data[position].priority
        holder.time.text=data[position].time
        holder.list.text=data[position].list
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }
}
}
