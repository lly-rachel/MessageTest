package com.example.testkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter (val msgList : List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {

        if(viewType == Msg.TYPE_RECEIVED){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
            return MsgViewHolder.LeftViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
            return MsgViewHolder.rightViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is MsgViewHolder.LeftViewHolder -> holder.leftMsg.text = msg.content
            is MsgViewHolder.rightViewHolder -> holder.rightMsg.text = msg.content

        }
    }

    override fun getItemCount() = msgList.size

}