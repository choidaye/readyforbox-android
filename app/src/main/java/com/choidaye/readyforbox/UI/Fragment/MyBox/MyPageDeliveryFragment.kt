package com.choidaye.readyforbox.UI.Fragment.MyBox


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Regular

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MyPageDeliveryManangerRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_my_page_delivery.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MyPageDeliveryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page_delivery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var mypageDeliverylist : ArrayList<Regular> = ArrayList()
        mypageDeliverylist.add(Regular("2019.06.16.10:33:22","2019183132na019283",1,3,"http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","삼다수","제주삼다수, 500ml, 40개입",1,10000,1))
        mypageDeliverylist.add(Regular("2019.06.16.10:33:22","2019183132na019283",1,3,"http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","삼다수","제주삼다수, 500ml, 40개입",1,10000,1))
        mypageDeliverylist.add(Regular("2019.06.16.10:33:22","2019183132na019283",1,3,"http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","삼다수","제주삼다수, 500ml, 40개입",1,10000,1))

        mypageDeliverylist.add(Regular("2019.06.16.10:33:22","2019183132na019283",1,3,"http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","삼다수","제주삼다수, 500ml, 40개입",1,10000,1))
        mypageDeliverylist.add(Regular("2019.06.16.10:33:22","2019183132na019283",1,3,"http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","삼다수","제주삼다수, 500ml, 40개입",1,10000,1))


        var myPageDeliveryManangerRecyclerViewAdapter = MyPageDeliveryManangerRecyclerViewAdapter(activity!!,mypageDeliverylist)
        rv_fg_my_page_delivery_list.adapter = myPageDeliveryManangerRecyclerViewAdapter
        rv_fg_my_page_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

    }


}
