package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Product

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.R.id.rv_fg_delivery_list
import com.choidaye.readyforbox.UI.Adapter.DeliveryRecyclcerViewAdapter
import kotlinx.android.synthetic.main.fragment_delivery_list.*
import kotlinx.android.synthetic.main.fragment_package_list.*


class DeliveryListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery_list, container, false)

        Log.v("oncreate", "온크리에이트가 안돼요")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setOnBtnClickListener()


        var deliveryList: ArrayList<Product> = ArrayList()
        deliveryList.add(
            Product(
                "삼다수",
                "http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",
                "제주삼다수, 500ml,40개입",
                17000,
                10000
            )
        )
        deliveryList.add(
            Product(
                "삼다수",
                "http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",
                "제주삼다수, 500ml,40개입",
                17000,
                10000
            )
        )
        deliveryList.add(
            Product(
                "삼다수",
                "http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",
                "제주삼다수, 500ml,40개입",
                17000,
                10000
            )
        )
        deliveryList.add(
            Product(
                "삼다수",
                "http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",
                "제주삼다수, 500ml,40개입",
                17000,
                10000
            )
        )
        deliveryList.add(
            Product(
                "삼다수",
                "http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",
                "제주삼다수, 500ml,40개입",
                17000,
                10000
            )
        )


        var deliveryRecyclcerViewAdapter = DeliveryRecyclcerViewAdapter(activity!!, deliveryList)
        rv_fg_delivery_list.adapter = deliveryRecyclcerViewAdapter
        rv_fg_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

    private fun setOnBtnClickListener() {

//        var result = tv_fg_package_filter.text
//
//        tv_fg_package_filter.setOnClickListener {
//            val popupMenu: PopupMenu = PopupMenu(activity!!, tv_fg_package_filter)
//            popupMenu.menuInflater.inflate(R.menu.menu_product_list_filter,popupMenu.menu)
//
////          popupMenu.setOnMenuItemClickListener {popupMenu.setOnMenuItemClickListener{item ->
////                when(item.itemId){
////
////
////
////
////            }
////
////
////
////
////        }


        }



}


