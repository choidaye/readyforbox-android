package com.choidaye.readyforbox.UI.Adapter

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition:  Int,toPosition: Int) :Boolean
    fun onItemDismiss(position: Int)
}