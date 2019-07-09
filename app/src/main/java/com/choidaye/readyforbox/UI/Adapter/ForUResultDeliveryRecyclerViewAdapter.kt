package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.ForUResultDelivery
import com.choidaye.readyforbox.R

class ForUResultDeliveryRecyclerViewAdapter(val ctx: Context, val forUresultDeliveryList: ArrayList<ForUResultDelivery>) : RecyclerView.Adapter<ForUResultDeliveryRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_for_u_result_delivery, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = forUresultDeliveryList.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        Glide.with(ctx)
            .load(forUresultDeliveryList[position].main_img)
            .into(holer.main_img)
        holer.name.text = forUresultDeliveryList[position].name
        holer.price.text=forUresultDeliveryList[position].price.toString()



    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView =  itemView.findViewById(R.id.tv_fg_for_u_result_name) as TextView
        val price: TextView = itemView.findViewById(R.id.tv_fg_for_u_result_price) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.img_fg_for_u_result_thumbnail) as ImageView



    }

}