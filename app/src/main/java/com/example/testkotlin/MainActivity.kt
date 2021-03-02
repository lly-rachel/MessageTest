package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var adapter : MsgAdapter? = null
    private val msgList = ArrayList<Msg>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // binding.but.setOnClickListener { finish() }
        binding.but.setOnClickListener { binding.hellotv.visibility = GONE }


        /******************************************************************/
        initMsg()
        binding.recycleview.layoutManager = LinearLayoutManager(this)
        binding.recycleview.adapter = MsgAdapter(msgList)


        binding.send.setOnClickListener {
            var content = binding.edittx.text.toString()
            if(content.isNotEmpty()){
                msgList.add(Msg(content,Msg.TYPE_SENT))
                binding.recycleview.adapter?.notifyItemInserted(msgList.size - 1)
                binding.recycleview.scrollToPosition(msgList.size - 1)
                binding.edittx.text = null
            }

        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello",Msg.TYPE_RECEIVED)
        val msg2 = Msg("hi!!",Msg.TYPE_SENT)
        val msg3 = Msg("What are you doing?",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        msgList.add(msg2)
        msgList.add(msg3)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.more,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.add_item -> binding.hellotv.visibility = VISIBLE
            R.id.delete_item -> binding.hellotv.visibility = GONE
        }

        return true
    }
}