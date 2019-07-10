package com.choidaye.readyforbox.DragListener

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.choidaye.readyforbox.UI.Adapter.ItemTouchHelperAdapter

class DragItemTouchHelperCallback(val itemTouchHelperAdapter: ItemTouchHelperAdapter): ItemTouchHelper.Callback() {
    //어느 방향으로 움직일 것에 따라 flag를 받는 것을 정의
    //드래그는 위와 아래로 하는 액션이므로 up,down을 넘겨줌
    override fun getMovementFlags(p0: RecyclerView, p1: RecyclerView.ViewHolder): Int {
        var dragFlags: Int= ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return makeMovementFlags(dragFlags,0)  //0으로 하면 swipe되지 않음
    }
    //움직이면 어떻게 할 것인지 구현
    //위아래 순서변경, 좌우로 스와이프 변경하려 한다면, 리스트의 데이터를 변경할 수 있는 adapter에서 callback메소드를 통해 실행할 수있도록 해야한다는 점
    //아이템을 드래그할때,itemTouchHelper가 onMove()호출
    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        itemTouchHelperAdapter.onItemMove(p1.adapterPosition,p2.adapterPosition)
        return true
    }

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }
}