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

class CartPackageRecyclerViewAdapter(val ctx: Context, val cartpackageList: ArrayList<CartData>) : RecyclerView.Adapter<CartPackageRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_ac_cart_package, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = cartpackageList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(cartpackageList[position].main_img)
            .into(holder.main_img)
        holder.name.text = cartpackageList[position].name
        holder.price.text= cartpackageList[position].price.toString()

    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView =  itemView.findViewById(R.id.btn_rv_item_ac_cart_package_check) as TextView
        val price: TextView = itemView.findViewById(R.id.tv_rv_ac_cart_package_price) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.iv_item_ac_cart_package) as ImageView


    }

}