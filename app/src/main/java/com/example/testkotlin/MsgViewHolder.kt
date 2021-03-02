package com.example.testkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

sealed class MsgViewHolder (view : View) : RecyclerView.ViewHolder(view){

    class LeftViewHolder(view : View):MsgViewHolder(view){
        val leftMsg : TextView = view.findViewById(R.id.left_msg_tv)
    }

    class rightViewHolder(view : View):MsgViewHolder(view){
        val rightMsg : TextView = view.findViewById(R.id.right_msg_tv)
    }
}