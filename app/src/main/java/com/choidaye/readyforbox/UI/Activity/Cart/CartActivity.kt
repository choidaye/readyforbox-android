package com.choidaye.readyforbox.UI.Activity.Cart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.choidaye.readyforbox.Data.CartData
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.CartPackageRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_cart.*


class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        setReclerView()
    }

    private fun setReclerView() {

        var cartPackageList: ArrayList<CartData> = ArrayList()

        cartPackageList.add(CartData("삼다수, ","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000,"1",1))



        var cartPackageRecyclcerViewAdapter = CartPackageRecyclerViewAdapter(this, cartPackageList)
        rv_ac_cart_package.adapter = cartPackageRecyclcerViewAdapter
        rv_ac_cart_package.layoutManager = LinearLayoutManager(this)




    }


}
