package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data = ArrayList<Wishlist>()

        val recyclerView = findViewById<RecyclerView>(R.id.rvWishList)

        recyclerView.layoutManager = LinearLayoutManager(this)
         recyclerView.adapter = WishlistAdapter(data)



        val productName = findViewById<EditText>(R.id.productName)
        val enterPrice = findViewById<EditText>(R.id.enterPrice)
        val itemUrl = findViewById<EditText>(R.id.itemUrl)


        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val name = productName.text.toString()
            val price = enterPrice.text.toString()
            val urlItem = itemUrl.text.toString()
            val wshItms = Wishlist(name,price,urlItem)
            data.add(wshItms)
            recyclerView.adapter?.notifyDataSetChanged()
        }

    }

}