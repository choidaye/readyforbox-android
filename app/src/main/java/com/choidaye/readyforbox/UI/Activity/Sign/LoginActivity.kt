package com.choidaye.readyforbox.UI.Activity.Sign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //아이디 클릭 효과
        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.select_login_border)
            else v.setBackgroundResource(R.drawable.primary_login_border)
        }
        //패스워드 클릭 효과
        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.select_login_border)
            else v.setBackgroundResource(R.drawable.primary_login_border)
        }
        //로그인 버튼 클릭 시(안 뜬 것 요구)
        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()

            if (login_u_id == "") edtLoginID.requestFocus()
            else if (login_u_pw == "") edtLoginPW.requestFocus()
            else postLoginResponse(login_u_id, login_u_pw)
        }

    }
    //로그인 버튼 시 효과
    fun postLoginResponse(login_u_id: String, login_u_pw: String) {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}