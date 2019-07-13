package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.R
import org.w3c.dom.Text

class SearchResultRecyclerViewAdapter(val ctx: Context, val searchList: ArrayList<Product>) : RecyclerView.Adapter<SearchResultRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultRecyclerViewAdapter.Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_search_result_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = searchList.size


    override fun onBindViewHolder(holer: SearchResultRecyclerViewAdapter.Holder, position: Int) {
        holer.name.text =searchList[position].name
        holer.content.text = searchList[position].content
        Glide.with(ctx)
            .load(searchList[position].main_img)
            .into(holer.main_img)
        holer.price.text = searchList[position].price.toString()
        holer.saled_price.text = searchList[position].saled_price.toString()




    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name : TextView = itemView.findViewById(R.id.tv_fg_search_result_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_fg_search_result_content) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.iv_fg_search_result_list) as ImageView
        val price : TextView = itemView.findViewById(R.id.tv_fg_search_result_original_cost) as TextView
        val saled_price : TextView = itemView.findViewById(R.id.tv_fg_package_list_saled_price) as TextView




    }

}