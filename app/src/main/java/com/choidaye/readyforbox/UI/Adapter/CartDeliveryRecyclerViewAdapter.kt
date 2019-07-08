package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.CartData
import com.choidaye.readyforbox.R

class CartDeliveryRecyclerViewAdapter(val ctx: Context, val cartdeliveryList: ArrayList<CartData>) : RecyclerView.Adapter<CartDeliveryRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_ac_cart_delivery, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = cartdeliveryList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(cartdeliveryList[position].main_img)
            .into(holder.main_img)
        holder.name.text = cartdeliveryList[position].name
        holder.price.text= cartdeliveryList[position].price.toString()
        holder.term.text = cartdeliveryList[position].term

    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView =  itemView.findViewById(R.id.btn_rv_item_ac_cart_delivery_check) as TextView
        val price: TextView = itemView.findViewById(R.id.tv_rv_ac_cart_delivery_price) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.iv_item_ac_cart_delivery) as ImageView
        val term : TextView = itemView.findViewById(R.id.tv_rv_ac_cart_delivery_term) as TextView
    }

}