package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.PackageDetail
import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.Get.GetPackageInfoResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.PackageDetailRecyclcerViewAdapter
import kotlinx.android.synthetic.main.activity_package.*
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.package_option.*
import kotlinx.android.synthetic.main.product_option.*
import kotlinx.android.synthetic.main.rv_item_fg_package_list.*
import org.jetbrains.anko.image
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PackageActivity : AppCompatActivity(){

    var name: String = ""
    var content : String = ""
    var package_id : Int = 0
    var main_img : String = ""
    var price : Int = 0
    var saled_price  : Int = 0

    var ratio : Int = 0

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    var packageDetailList = ArrayList<Product>()

    lateinit var packageDetailRecyclcerViewAdapter :PackageDetailRecyclcerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)



        tv_ac_package_ratio.text = ratio.toString()
        tv_ac_package_name.text = name
        txt_package_detail_realPrice.text = price.toString()

        //package_id = intent.getIntExtra("package_id",-1)



        val intent: Intent = intent
        val value=intent.getStringExtra("package_id")
        Log.e("value",value)
        setResult(Activity.RESULT_OK,intent)


        setRecyclerView()


        getPackageInfoResponse(value)

        txt_package_detail_realPrice.paintFlags=txt_package_detail_realPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        var bottomSheet= BottomSheetBehavior.from(package_option)
        btn_package_buy.setOnClickListener {
            package_option.visibility= View.VISIBLE
            package_blur.visibility= View.VISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_EXPANDED
        }





        package_img_minus.setOnClickListener {
            var count=Integer.parseInt(txt_package_count.text.toString())
            if(count>1){
                count--
                txt_package_count.text=count.toString()
            }
        }
        package_img_plus.setOnClickListener{
            var count=Integer.parseInt(txt_package_count.text.toString())
            if(count<8){
                count++
                txt_package_count.text=count.toString()
            }
        }
        btn_package_addCart.setOnClickListener {
            package_option.visibility= View.INVISIBLE
            package_blur.visibility= View.INVISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_COLLAPSED

            val toast: Toast = Toast.makeText(this,"장바구니 추가", Toast.LENGTH_LONG)
            toast.view=layoutInflater.inflate(R.layout.product_cart_dialog,null)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        package_blur.setOnClickListener {
            package_option.visibility=View.INVISIBLE
            package_blur.visibility=View.INVISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_COLLAPSED
        }
    }



    private fun setRecyclerView() {

        packageDetailRecyclcerViewAdapter= PackageDetailRecyclcerViewAdapter(applicationContext!!,packageDetailList)
        rv_item_package_detail_all.adapter=packageDetailRecyclcerViewAdapter
        rv_item_package_detail_all.layoutManager=GridLayoutManager(applicationContext!!,2)


    }


    private fun getPackageInfoResponse(package_id : String) {


        setResult(Activity.RESULT_OK,intent)
        Log.e("response", "리스폰스 들어옴")

        var getPackageInfoResponse = networkService.getPackageInfoResponse(package_id)
        getPackageInfoResponse.enqueue(object : Callback<GetPackageInfoResponse> {

            override fun onResponse(call: Call<GetPackageInfoResponse>?, response: Response<GetPackageInfoResponse>) {

                Log.e("response","리스폰스 확인")


                if (response.isSuccessful){


                    Log.v("response body", response.body().toString())

                    Log.v("successful", "통신성공")



                        name = response.body()!!.data.name
                        ratio = response.body()!!.data.sale_ratio
                        price = response.body()!!.data.price
                        saled_price = response.body()!!.data.saled_price
                        main_img = response.body()!!.data.main_img

                        setDetailedPackage(name,ratio,main_img,saled_price,price)


                    var temp : ArrayList<Product> = response.body()!!.data.product
                   packageDetailRecyclcerViewAdapter.packageDetailList.addAll(temp)
                   packageDetailRecyclcerViewAdapter.notifyDataSetChanged()











                }else{
                    Log.v("response data", "서버 값 전달 오류")

                }


            }

            override fun onFailure(call: Call<GetPackageInfoResponse>, t: Throwable) {

            }
        })

    }


    private fun setDetailedPackage(name: String, sale_ratio: Int, image: String,saled_price : Int, price : Int) {


        name?.let {
            tv_ac_package_name.text = name
        }
        sale_ratio?.let {
            tv_ac_package_ratio.text = sale_ratio.toString()
        }

        image?.let {
            Glide.with(this).load(image).into(iv_ac_package_main)
        }

        saled_price?.let{
            tv_ac_package_saled_price.text = saled_price.toString()

        }

        price?.let {
            txt_package_detail_realPrice.text = price.toString()
        }



    }



}
