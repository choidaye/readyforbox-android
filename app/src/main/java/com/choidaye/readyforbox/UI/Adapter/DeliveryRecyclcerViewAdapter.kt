package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.R

class DeliveryRecyclcerViewAdapter(val ctx: Context, val deliveryList: ArrayList<Product>) : RecyclerView.Adapter<DeliveryRecyclcerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_delivery_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = deliveryList.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        Glide.with(ctx)
            .load(deliveryList[position].main_img)
            .into(holer.main_img)
        holer.name.text = deliveryList[position].name
        holer.price.text=deliveryList[position].price.toString()
        holer.saled_price.text = deliveryList[position].saled_price.toString()
        holer.content.text = deliveryList[position].content


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView =  itemView.findViewById(R.id.tv_fg_delivery_list_title) as TextView
        val price: TextView = itemView.findViewById(R.id.tv_fg_delivery_list_original_cost) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.iv_item_fg_delivery_list) as ImageView
        val saled_price : TextView = itemView.findViewById(R.id.tv_fg_delivery_list_saled_price)as TextView
        val content : TextView = itemView.findViewById(R.id.tv_fg_delivery_list_content) as TextView


    }

}