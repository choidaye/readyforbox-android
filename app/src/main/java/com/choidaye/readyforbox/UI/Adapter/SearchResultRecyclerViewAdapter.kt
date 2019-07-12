package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.Data.SearchData
import com.choidaye.readyforbox.R

class SearchResultRecyclerViewAdapter(val ctx: Context, val searchList: ArrayList<Product>) : RecyclerView.Adapter<SearchResultRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultRecyclerViewAdapter.Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_search_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = searchList.size


    override fun onBindViewHolder(holer: SearchResultRecyclerViewAdapter.Holder, position: Int) {


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}