package com.choidaye.readyforbox.DragListener

import com.choidaye.readyforbox.UI.Adapter.DragListRecyclcerViewAdapter

interface OnStartDragListener {
    public abstract fun onStartDrag(holder: DragListRecyclcerViewAdapter.Holder)
}