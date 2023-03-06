package com.example.todoappproject

object DataObject {
    var listdata= mutableListOf<CardInfo>()

    fun setData(title: String, priority: String, time: String, list: String){
        listdata.add(CardInfo(title, priority, time, list))
    }

    fun getAllData():List<CardInfo>
    {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }

    fun deleteData(pos: Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos: Int, title: String, priority: String, time: String, list: String){
        listdata[pos].title=title
        listdata[pos].priority=priority
        listdata[pos].time=time
        listdata[pos].list=list
    }
}