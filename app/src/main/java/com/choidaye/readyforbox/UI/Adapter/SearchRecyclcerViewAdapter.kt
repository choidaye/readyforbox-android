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
import com.choidaye.readyforbox.Data.SearchData
import com.choidaye.readyforbox.R

class SearchRecyclcerViewAdapter(val ctx: Context, val searchList: ArrayList<SearchData>) : RecyclerView.Adapter<SearchRecyclcerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclcerViewAdapter.Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_search_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = searchList.size


    override fun onBindViewHolder(holer: SearchRecyclcerViewAdapter.Holder, position: Int) {
        holer.keyword.text = searchList[position].keyword



    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val keyword : TextView =  itemView.findViewById(R.id.tv_fg_search_keyword) as TextView

    }

}