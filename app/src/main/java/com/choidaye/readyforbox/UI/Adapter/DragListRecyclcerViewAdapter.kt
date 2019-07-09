package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.DragAndDrop
import com.choidaye.readyforbox.DragListener.OnStartDragListener
import com.choidaye.readyforbox.R
import java.util.ArrayList

class DragListRecyclcerViewAdapter(val ctx: Context, val dataList: ArrayList<DragAndDrop>, val onStartDragListener: OnStartDragListener): RecyclerView.Adapter<DragListRecyclcerViewAdapter.Holder>(),ItemTouchHelperAdapter{
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.for_u_drag_list_view,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount(): Int =dataList.size

    override fun onBindViewHolder(holder: Holder, p1: Int) {
        holder.name.text=dataList[p1].name
        Glide.with(ctx).load(dataList[p1].img_url).into(holder.img)
        //drag and drop
        holder.img.setOnTouchListener{v,event->
            if(event.action== MotionEvent.ACTION_DOWN){
                onStartDragListener.onStartDrag(holder)
                true
            }else {
                false
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) :Boolean{
        if(fromPosition==toPosition){
            false
        }
        val fromItem=dataList.removeAt(fromPosition)
        dataList.add(toPosition,fromItem)
        notifyItemMoved(fromPosition,toPosition)

        return true
    }

    override fun onItemDismiss(position: Int) {
        dataList.remove(dataList[position])
        notifyItemRemoved(position)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name=itemView.findViewById(R.id.lt_setting_name) as TextView
        var img=itemView.findViewById(R.id.img_setting_move) as ImageView
    }
}