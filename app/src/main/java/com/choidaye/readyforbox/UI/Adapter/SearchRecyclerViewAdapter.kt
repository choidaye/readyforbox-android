package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.choidaye.readyforbox.Data.SearchData
import com.choidaye.readyforbox.R

class SearchRecyclerViewAdapter(val ctx: Context, val searchList: ArrayList<SearchData>) : RecyclerView.Adapter<SearchRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerViewAdapter.Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_search_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = searchList.size


    override fun onBindViewHolder(holer: SearchRecyclerViewAdapter.Holder, position: Int) {


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

}