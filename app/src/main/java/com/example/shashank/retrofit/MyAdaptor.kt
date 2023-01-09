package com.example.shashank.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class MyAdaptor(val contextList:ArrayList<MyDataItem>):RecyclerView.Adapter<MyAdaptor.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val cate = itemView.findViewById<TextView>(R.id.TextView)
        val des = itemView.findViewById<TextView>(R.id.TextView1)
        fun bindItems(users:MyDataItem){
            cate.text = users.Category
            des.text = users.Description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view,parent,false)
    return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(contextList[position])
    }

    override fun getItemCount(): Int {
        return contextList.size
    }
}