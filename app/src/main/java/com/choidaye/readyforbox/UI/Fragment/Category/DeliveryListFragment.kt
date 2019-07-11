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
import com.choidaye.readyforbox.UI.Activity.ProductDetailActivity
import com.choidaye.readyforbox.UI.Adapter.DeliveryRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_delivery_list.*
import org.jetbrains.anko.support.v4.startActivity


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


        //툴바 이름 바꾸기
//       val extra = arguments
//        toolbar_delivery_list_title.text= extra!!.getString("name")
//

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


        var deliveryRecyclcerViewAdapter = DeliveryRecyclerViewAdapter(activity!!, deliveryList){ Product ->
            startActivity<ProductDetailActivity>()
        }
        rv_fg_delivery_list.adapter = deliveryRecyclcerViewAdapter
        rv_fg_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

    private  fun clearbuttonTextColor(){
        tv_fg_delivery_list_water.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_detergent.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_tissue.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_bathroom.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_defuser.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_cook.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_clean.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_animal.setTextColor(resources.getColor(R.color.darkGrey))
}


    private fun setOnBtnClickListener() {


            btn_fg_delivery_list_water.setOnClickListener {


                clearbuttonTextColor()
                tv_fg_delivery_list_water.setTextColor(resources.getColor(R.color.pumpkinOrange))

            }



            btn_fg_delivery_list_detergent.setOnClickListener {

                clearbuttonTextColor()
                tv_fg_delivery_list_detergent.setTextColor(resources.getColor(R.color.pumpkinOrange))

            }


            btn_fg_delivery_list_tissue.setOnClickListener {

                clearbuttonTextColor()
                tv_fg_delivery_list_tissue.setTextColor(resources.getColor(R.color.pumpkinOrange))

            }


            btn_fg_delivery_list_clean.setOnClickListener {
                //툴바 이름 바꾸기
                //toolbar_delivery_list_title.text = tv_fg_delivery_lsit_clean.text



                clearbuttonTextColor()
                tv_fg_delivery_list_clean.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }


            btn_fg_delivery_list_animal.setOnClickListener {

                clearbuttonTextColor()
                tv_fg_delivery_list_animal.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }


            btn_fg_delivery_list_cook.setOnClickListener {

                clearbuttonTextColor()
                tv_fg_delivery_list_cook.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }



        btn_fg_delivery_list_defuser.setOnClickListener {

            clearbuttonTextColor()
            tv_fg_delivery_list_defuser.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }

        btn_fg_delivery_list_bathroom.setOnClickListener {

            clearbuttonTextColor()
            tv_fg_delivery_list_bathroom.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }



    }



}


