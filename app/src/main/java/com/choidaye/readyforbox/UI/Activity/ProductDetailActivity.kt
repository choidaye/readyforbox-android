package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Get.GetProductInfoResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_package.*
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_option.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailActivity : AppCompatActivity() {
    var isChecking: Boolean = true


    var name : String = ""
    var content : String= ""
    var main_img : String = ""
    var price : Int = 0
    var saled_price : Int = 0
    var content_img = ArrayList<String>()









    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)





        tV_ac_product_detail_name.text = name
        tv_ac_product_detail_saled_price.text = saled_price.toString()
        txt_product_realPrice.paintFlags=txt_product_realPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG






        val intent: Intent = intent
        val value=intent.getStringExtra("product_id")

        Log.e("value",value)

        setResult(Activity.RESULT_OK,intent)





        var bottomSheet= BottomSheetBehavior.from(product_option)
        btn_product_buy.setOnClickListener {
            product_option.visibility= View.VISIBLE
            product_blur.visibility= View.VISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_EXPANDED
        }
        //multi-line radio button

        rb_one_month.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_one_month.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_one_month.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_two_month.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_two_month.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_two_month.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_three_month.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_three_month.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_three_month.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_four_month.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_four_month.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_four_month.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        img_minus.setOnClickListener {
            var count=Integer.parseInt(txt_product_count.text.toString())
            if(count>1){
                count--
                txt_product_count.text=count.toString()
            }
        }
        img_plus.setOnClickListener{
            var count=Integer.parseInt(txt_product_count.text.toString())
            if(count<8){
                count++
                txt_product_count.text=count.toString()
            }
        }
        btn_product_addCart.setOnClickListener {
            product_option.visibility= View.INVISIBLE
            product_blur.visibility= View.INVISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_COLLAPSED

            val toast: Toast = Toast.makeText(this,"장바구니 추가", Toast.LENGTH_LONG)
            toast.view=layoutInflater.inflate(R.layout.product_cart_dialog,null)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        product_blur.setOnClickListener{
            product_option.visibility= View.INVISIBLE
            product_blur.visibility= View.INVISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_COLLAPSED
        }



        getProductinfoResponse(value)

    }

    private fun getProductinfoResponse(product_id:String) {

        setResult(Activity.RESULT_OK,intent)


        Log.e("response", "리스폰스 들어옴")

        var getProductinfoResponse = networkService.getProductinfoResponse(product_id)
        getProductinfoResponse.enqueue(object : Callback<GetProductInfoResponse> {

            override fun onResponse(call: Call<GetProductInfoResponse>, response: Response<GetProductInfoResponse>) {

                Log.e("response","리스폰스 확인")


                if (response.isSuccessful){


                    Log.v("response body", response.body().toString())

                    Log.v("successful", "통신성공")


                    name = response.body()!!.data.name
                    price = response.body()!!.data.price
                    saled_price = response.body()!!.data.saled_price
                    main_img = response.body()!!.data.main_img
                    content_img = response.body()!!.data.content_img
                    content = response.body()!!.data.content



                    setProductView(name,saled_price,main_img,saled_price,price,content)




                }else{
                    Log.v("response data", "서버 값 전달 오류")

                }


            }

            override fun onFailure(call: Call<GetProductInfoResponse>, t: Throwable) {

            }
        })


    }


    private fun setProductView(name: String, sale_ratio: Int, main_img: String,saled_price : Int, price : Int, content : String){

        name?.let {
            tV_ac_product_detail_name.text = name
        }

        content?.let{
            tv_ac_product_detail_content.text = content
        }

        main_img?.let{
            Glide.with(this).load(main_img).into(iv_ac_product_detail)
        }

        sale_ratio?.let{
            tv_ac_product_detail_ratio.text = sale_ratio.toString()
        }

        saled_price?.let{
            tv_ac_product_detail_saled_price.text = saled_price.toString()
        }

        price?.let{
            txt_product_realPrice.text = price.toString()
        }

        content_img?.let{
            Glide.with(this).load(main_img).into(iv_ac_product_detail_content_img)
        }






    }
}
