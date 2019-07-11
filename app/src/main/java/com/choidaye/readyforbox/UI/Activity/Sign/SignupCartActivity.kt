package com.choidaye.readyforbox.UI.Activity.Sign

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import com.choidaye.readyforbox.UI.Activity.WebviewActivity
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.ic_toolbar_back
import kotlinx.android.synthetic.main.activity_signup_cart.*

class SignupCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_cart)

        val login_u_id = intent.getStringExtra("loginName")
        edtCartName.setText(login_u_id)

        val login_u_num = intent.getStringExtra("loginNum")
        val num1: String = login_u_num.substring(0, 3)
        val num2: String = login_u_num.substring(3, 7)
        val num3: String = login_u_num.substring(7)
        edtCartNum1.setText(num1)
        edtCartNum2.setText(num2)
        edtCartNum3.setText(num3)

//        val login_u_id = edtLoginID.text.toString()
//        Log.e("myTag", "CartInformation_name:" + login_u_id)

        //뒤로 가기 버튼(장바구니로 다시 가야함)--수정 필요
        ic_toolbar_back.setOnClickListener {
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            startActivity(intent)
        }
        btn_ac_signupup.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //빈칸일때 버튼 색 안바뀌고, 버튼 클릭 안되게하는 것!
//빈칸일 때 버튼이 클릭이 안되게 만드는 것 / 버튼 색 안바뀌게 되는 것이 안먹음...ㅜㅜㅠㅜㅠㅜ
        val textChangeListener: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (edtCartName.text.toString() == "" ||
                    edtCartNum1.text.toString() == "" ||
                    edtCartNum2.text.toString() == "" ||
                    edtCartNum3.text.toString() == "" ||
                    edtAddressNum.text.toString() == "" ||
                    edtAddress.text.toString() == "" ||
                    edtAddressdetail.text.toString() == ""
                ) {
                    btn_ac_signup_nextcom.setBackgroundColor(resources.getColor(R.color.blueGrey))
                    btn_ac_signup_nextcom.isClickable = false
                } else {
                    btn_ac_signup_nextcom.setBackgroundColor(resources.getColor(R.color.pumpkinOrange))
                    btn_ac_signup_nextcom.isClickable = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
        //추후 변경
        btn_ac_signup_nextcom.setOnClickListener {
            //            val intent: Intent = Intent(this, MainActivity::class.java)
//            //startActivityForResult(intent, 100)
            val cart_name = edtCartName.text.toString()
            val cart_num1 = edtCartNum1.text.toString()
            val cart_num2 = edtCartNum2.text.toString()
            val cart_num3 = edtCartNum3.text.toString()
            val address_num = edtAddressNum.text.toString()
            val address = edtAddress.text.toString()
            val address_detail = edtAddressdetail.text.toString()

            if (cart_name == "") edtCartName.requestFocus()
            else if (cart_num1 == "") edtCartNum1.requestFocus()
            else if (cart_num2 == "") edtCartNum2.requestFocus()
            else if (cart_num3 == "") edtCartNum3.requestFocus()
            else if (address_num == "") edtAddressNum.requestFocus()
            else if (address == "") edtAddress.requestFocus()
            else if (address_detail == "") edtAddressdetail.requestFocus()
            else postSignupResponse(cart_name, cart_num1, cart_num2, cart_num3, address_num, address, address_detail)
        }
        btnLogindelivery.setOnClickListener{
            val intent: Intent = Intent(this, PopupDeliveryActivity::class.java)
            startActivityForResult(intent, 1000)
        }

        btn_ac_cartif_search.setOnClickListener {
            val intent: Intent = Intent(this, WebviewActivity::class.java)
            startActivityForResult(intent, 2000)
        }
//        val zoneCode = intent.getStringExtra("zoneCode")
//        edtAddressNum.setText(zoneCode)
        // Log.e("myTag", "SignupCartActivity" + zoneCode)

    }

    fun postSignupResponse(
        cart_name: String,
        cart_num1: String,
        cart_num2: String,
        cart_num3: String,
        address_num: String,
        address: String,
        address_detail: String
    ) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {
                val str: String = data!!.getStringExtra("zoneCode")
                edtAddressNum.setText(str)
                val address: String = data!!.getStringExtra("address")
                val buildingName: String = data!!.getStringExtra("buildingName")
                edtAddress.setText(address + buildingName)

                Log.e("myTag", "SignupCartActivity" + str)

            }
        }
        if(requestCode==1000){
            if(resultCode==Activity.RESULT_OK) {
                val door: String = data!!.getStringExtra("door")
                btnLogindelivery.setText(door)
            }
        }
    }

}