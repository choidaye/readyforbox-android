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

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.ForUResultDeliveryRecyclcerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultHelpRecyclcerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultPackageRecyclcerViewAdapter
import kotlinx.android.synthetic.main.fragment_for_u_result.*
import kotlinx.android.synthetic.main.fragment_package_list.*



class ForUResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_for_u_result, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var forUresultpackageList : ArrayList<ForUResultPackage> = ArrayList()

        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))

        var forUResultPackageRecyclcerViewAdapter = ForUResultPackageRecyclcerViewAdapter(activity!!,forUresultpackageList)
        rv_fg_for_u_ready_for_package.adapter = forUResultPackageRecyclcerViewAdapter
        rv_fg_for_u_ready_for_package.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)



        var forUresultdeliveryList : ArrayList<ForUResultDelivery> = ArrayList()

        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))

        var forUResultDeliveryRecyclcerViewAdapter = ForUResultDeliveryRecyclcerViewAdapter(activity!!,forUresultdeliveryList)
        rv_fg_for_u_ready_for_delivery.adapter = forUResultDeliveryRecyclcerViewAdapter
        rv_fg_for_u_ready_for_delivery.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)


        var forUresulthelpList : ArrayList<ForUResultHelp> = ArrayList()

        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))


        var forUResultHelpRecyclcerViewAdapter = ForUResultHelpRecyclcerViewAdapter(activity!!,forUresulthelpList)
        rv_fg_for_u_ready_for_help.adapter = forUResultHelpRecyclcerViewAdapter
        rv_fg_for_u_ready_for_help.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)




    }


}
