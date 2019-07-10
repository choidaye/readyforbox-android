package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import com.choidaye.readyforbox.R
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
        //추후 변경
        btn_ac_signup_nextcom.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            //startActivityForResult(intent, 100)
        }
        btn_ac_cartif_search.setOnClickListener {
            val intent: Intent = Intent(this, WebviewActivity::class.java)
            startActivityForResult(intent,2000)
        }
//        val zoneCode = intent.getStringExtra("zoneCode")
//        edtAddressNum.setText(zoneCode)
       // Log.e("myTag", "SignupCartActivity" + zoneCode)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if(requestCode == 2000) {
           if(resultCode == Activity.RESULT_OK) {
               val str: String = data!!.getStringExtra("zoneCode")
               edtAddressNum.setText(str)
               val address: String = data!!.getStringExtra("address")
               val buildingName: String = data!!.getStringExtra("buildingName")
               edtAddress.setText(address+buildingName)

               Log.e("myTag", "SignupCartActivity" + str)

           }
       }
    }
//
//    override fun onResume() {
//        super.onResume()
//
//
//    }
}