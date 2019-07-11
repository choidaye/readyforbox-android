package com.choidaye.readyforbox.UI.Fragment.ForU


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.ForUResultDelivery
import com.choidaye.readyforbox.Data.ForUResultHelp
import com.choidaye.readyforbox.Data.ForUResultPackage
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.ForUResultDeliveryRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultHelpRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultPackageRecyclerViewAdapter


import kotlinx.android.synthetic.main.fragment_for_u_result.*


class ForUResultFragment : Fragment() {




    var forUresultpackageList = ArrayList<ForUResultPackage>()
    var forUresultdeliveryList = ArrayList<ForUResultDelivery>()
    var forUresulthelpList = ArrayList<ForUResultHelp>()



    lateinit var forUResultPackageRecyclerViewAdapter : ForUResultPackageRecyclerViewAdapter
    lateinit var forUResultDeliveryRecyclerViewAdapter : ForUResultDeliveryRecyclerViewAdapter
    lateinit var forUResultHelpRecyclerViewAdapter : ForUResultHelpRecyclerViewAdapter




    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_for_u_result, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        setRecyclerView()



        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))




        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))





        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))






    }

    private fun setRecyclerView() {




        forUResultPackageRecyclerViewAdapter = ForUResultPackageRecyclerViewAdapter(activity!!,forUresultpackageList)
        rv_fg_for_u_ready_for_package.adapter = forUResultPackageRecyclerViewAdapter
        rv_fg_for_u_ready_for_package.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)





        forUResultDeliveryRecyclerViewAdapter = ForUResultDeliveryRecyclerViewAdapter(activity!!,forUresultdeliveryList)
        rv_fg_for_u_ready_for_delivery.adapter = forUResultDeliveryRecyclerViewAdapter
        rv_fg_for_u_ready_for_delivery.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)



        //

        forUResultHelpRecyclerViewAdapter = ForUResultHelpRecyclerViewAdapter(activity!!,forUresulthelpList)
        rv_fg_for_u_ready_for_help.adapter = forUResultHelpRecyclerViewAdapter
        rv_fg_for_u_ready_for_help.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)


    }


}
