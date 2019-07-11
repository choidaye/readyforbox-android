package com.choidaye.readyforbox.UI.Activity

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.GridLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.choidaye.readyforbox.Data.PackageDetail
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.PackageDetailRecyclcerViewAdapter
import kotlinx.android.synthetic.main.activity_package.*
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.package_option.*
import kotlinx.android.synthetic.main.product_option.*
import kotlinx.android.synthetic.main.rv_item_fg_package_list.*
import org.jetbrains.anko.startActivity

class PackageActivity : AppCompatActivity(){
    lateinit var packageDetailRecyclcerViewAdapter :PackageDetailRecyclcerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)

        txt_package_detail_realPrice.paintFlags=txt_package_detail_realPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        var bottomSheet= BottomSheetBehavior.from(package_option)
        btn_package_buy.setOnClickListener {
            package_option.visibility= View.VISIBLE
            package_blur.visibility= View.VISIBLE
            bottomSheet.state= BottomSheetBehavior.STATE_EXPANDED
        }

        var packageDetailList : ArrayList<PackageDetail> = ArrayList()
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))

        packageDetailRecyclcerViewAdapter= PackageDetailRecyclcerViewAdapter(applicationContext!!,packageDetailList)
        rv_item_package_detail_all.adapter=packageDetailRecyclcerViewAdapter
        rv_item_package_detail_all.layoutManager=GridLayoutManager(applicationContext!!,2)


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


}
