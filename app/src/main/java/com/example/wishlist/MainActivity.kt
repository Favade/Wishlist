package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wishRv: RecyclerView
    private lateinit var submitButton: Button
    val emptyWishList = ArrayList<Wishlist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        wishRv = findViewById(R.id.rvWishList)
        val adapter = WishlistAdapter(emptyWishList)
        wishRv.adapter = adapter
        wishRv.layoutManager = LinearLayoutManager(this)
         submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {

            val productName = findViewById<EditText>(R.id.productName)
            val enterPrice = findViewById<EditText>(R.id.enterPrice)
            val itemUrl = findViewById<EditText>(R.id.itemUrl)

            val name = productName.text.toString()
            val price = enterPrice.text.toString().toDouble()
            val urlItem = itemUrl.text.toString()
            val wshItms = Wishlist(name, price,urlItem)
                emptyWishList.add(wshItms)
            adapter.notifyItemInserted(emptyWishList.size - 1)
        }


    }

}