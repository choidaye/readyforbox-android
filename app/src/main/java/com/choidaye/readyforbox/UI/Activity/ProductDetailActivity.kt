package com.choidaye.readyforbox.UI.Activity

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_option.*

class ProductDetailActivity : AppCompatActivity() {
    var isChecking: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        txt_product_realPrice.paintFlags=txt_product_realPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

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
    }
}
