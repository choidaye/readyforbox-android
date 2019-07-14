package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.PackageDetail
import com.choidaye.readyforbox.Data.Regularity
import com.choidaye.readyforbox.R


class MyPageDeliveryManangerRecyclerViewAdapter(val ctx: Context, val mypageDeliveryList: ArrayList<Regularity>) : RecyclerView.Adapter<MyPageDeliveryManangerRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_ac_my_page_delivery_check_product, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = mypageDeliveryList.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        Glide.with(ctx)
            .load(mypageDeliveryList[position].main_img)
            .into(holer.main_img)
        holer.content.text= mypageDeliveryList[position].name
        holer.delivery_cycle.text = mypageDeliveryList[position].delivery_cycle.toString()
        holer.delivery_day.text = mypageDeliveryList[position].delivery_day.toString()
        holer.count.text = mypageDeliveryList[position].count.toString()



    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val main_img : ImageView = itemView.findViewById(R.id.iv_item_ac_my_page_delivery_check_product) as ImageView
        val content : TextView = itemView.findViewById(R.id.tv_ac_my_page_delivery_check_product_term)as TextView
        val delivery_cycle : TextView = itemView.findViewById(R.id.tv_ac_my_page_delivery_check_product_term) as TextView
        val delivery_day :TextView = itemView.findViewById(R.id.tv_ac_my_page_delivery_check_product_date) as TextView
        val count : TextView = itemView.findViewById(R.id.tv_ac_my_page_delivery_check_product_num) as TextView
    }

}