package com.choidaye.readyforbox.UI.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        var num1: String = login_u_num.substring(0, 3)
        val num2: String = login_u_num.substring(3, 7)
        var num3: String = login_u_num.substring(7)
        edtCartNum1.setText(num1)
        edtCartNum2.setText(num2)
        edtCartNum3.setText(num3)


//        val login_u_id = edtLoginID.text.toString()
//        Log.e("myTag", "CartInformation_name:" + login_u_id)

        //뒤로 가기 버튼(장바구니로 다시 가야함)--수정 필요
        ic_toolbar_back.setOnClickListener {
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_ac_signupup.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        //추후 변경
        btn_ac_signup_nextcom.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //배송메모 클릭 효과
        edtLogindelivery.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.select_ground)
            else v.setBackgroundResource(R.drawable.primary_ground)
        }
//        btn_ac_cartif_search.setOnClickListener()
    }
}