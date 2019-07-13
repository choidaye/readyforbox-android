package com.choidaye.readyforbox.UI.Activity.Cart

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.choidaye.readyforbox.Data.CartData
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.Sign.PopupDeliveryActivity
import com.choidaye.readyforbox.UI.Adapter.CartPackageRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_signup_cart.*
import kotlinx.android.synthetic.main.rv_item_ac_cart_delivery.*
import kotlinx.android.synthetic.main.rv_item_ac_cart_delivery.view.*


class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setReclerView()
//        btn_ac_cart_order.setOnClickListener {
//            startActivity<PopupCartActivity>()
//        }

//        this.rv_ac_cart_delivery.img_cart_count.setOnClickListener{
//            val intent: Intent = Intent(this, PopupCartActivity::class.java)
//            startActivityForResult(intent, 3000)
//        }
    }

    private fun setReclerView() {

        var cartPackageList: ArrayList<CartData> = ArrayList()

        cartPackageList.add(CartData("삼다수, ","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000,"1",1))



        var cartPackageRecyclcerViewAdapter = CartPackageRecyclerViewAdapter(this, cartPackageList)
        rv_ac_cart_package.adapter = cartPackageRecyclcerViewAdapter
        rv_ac_cart_package.layoutManager = LinearLayoutManager(this)




    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == 3000) {
//            if (resultCode == Activity.RESULT_OK) {
//                //val values: String? = data!!.getStringExtra("values")
//                val one: String? = data!!.getStringExtra("one")
//                val two: String? = data!!.getStringExtra("two")
//                val three: String? = data!!.getStringExtra("three")
//                val four: String? = data!!.getStringExtra("four")
//                val five: String? = data!!.getStringExtra("five")
//                val six: String? = data!!.getStringExtra("six")
//                val seven: String? = data!!.getStringExtra("seven")
//                val eight: String? = data!!.getStringExtra("eight")
//
//                if (one != null) tv_rv_ac_cart_delivery_num.setText(one)
//                else if (two != null) tv_rv_ac_cart_delivery_num.setText(two)
//                else if (three != null) tv_rv_ac_cart_delivery_num.setText(three)
//                else if (four != null) tv_rv_ac_cart_delivery_num.setText(four)
//                else if (five != null) tv_rv_ac_cart_delivery_num.setText(five)
//                else if (six != null) tv_rv_ac_cart_delivery_num.setText(six)
//                else if (seven != null) tv_rv_ac_cart_delivery_num.setText(seven)
//                else edtLogindelivery.setText(eight)
//            }
//        }
//    }




}
