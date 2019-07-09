package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Product

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.PackageRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_package_list.*



class PackageListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_package_list, container, false)

        Log.v("oncreate","온크리에이트가 안돼요")
    }


    override  fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnBtnClickListener()


        var packageList : ArrayList<Product> = ArrayList()
        packageList.add(Product("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제주삼다수, 500ml,40개입",17000,10000))
        packageList.add(Product("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제주삼다수, 500ml,40개입",17000,10000))
        packageList.add(Product("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제주삼다수, 500ml,40개입",17000,10000))
        packageList.add(Product("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제주삼다수, 500ml,40개입",17000,10000))
        packageList.add(Product("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제주삼다수, 500ml,40개입",17000,10000))


        var packageRecyclcerViewAdapter =PackageRecyclerViewAdapter(activity!!,packageList)
        rv_fg_package_list.adapter = packageRecyclcerViewAdapter
        rv_fg_package_list.layoutManager =  LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

    private fun setOnBtnClickListener() {
        btn_fg_package_list_appliances.setOnClickListener {


        }
    }


}
