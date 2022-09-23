package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WishlistAdapter(private var wsh: ArrayList<Wishlist>):
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView : TextView

        init {
            nameTextView = itemView.findViewById(R.id.tvItemName)
            priceTextView = itemView.findViewById(R.id.tvItemPrice)
            urlTextView = itemView.findViewById(R.id.itemUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val wish = wsh[position]
        viewHolder.nameTextView.text  = wish.name
        viewHolder.priceTextView.text  = wish.price.toString()
        viewHolder.urlTextView.text = wish.url
    }

    override fun getItemCount(): Int {
        return wsh.size
    }
}