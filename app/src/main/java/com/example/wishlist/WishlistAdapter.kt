package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
import org.w3c.dom.Text

class WishlistAdapter(private var wsh: ArrayList<Wishlist>):
    RecyclerView.Adapter<WishlistAdapter.WishListViewHolder>() {

     class WishListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
         val name = itemView.findViewById<TextView>(R.id.tvItemName)
         val price = itemView.findViewById<TextView>(R.id.tvItemPrice)
         val url = itemView.findViewById<TextView>(R.id.tvItemUrl)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):WishListViewHolder {
        return WishListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wishlist_items, parent, false))

    }

    override fun onBindViewHolder(viewHolder: WishListViewHolder, position: Int) {
        val wish = wsh[position]
        viewHolder.name.text  = wish.name
        viewHolder.price.text  = wish.price
        viewHolder.url.text = wish.url
    }

    override fun getItemCount(): Int {
        return wsh.size
    }
}