package com.choidaye.readyforbox.UI.Activity.Sign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.edtLoginID
import kotlinx.android.synthetic.main.activity_signup.edtLoginPW
import kotlinx.android.synthetic.main.activity_signup.view.*

class SignupActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //보여지는 화면
        setContentView(R.layout.activity_signup)
        //configureNext()
        //setOnClickListener()
        val textChangeListener: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (edtLoginNum.text.toString() == "" ||
                    edtLoginBir.text.toString() == "" ||
                    edtLoginName.text.toString() == "" ||
                    edtLoginPW.text.toString() == "" ||
                    edtLoginID.text.toString() == "" ||
                    rg_check.checkedRadioButtonId == -1
                ) {
                    btn_ac_signup_next.setBackgroundColor(resources.getColor(R.color.blueGrey))
                    btn_ac_signup_next.isClickable = false
                } else {
                    btn_ac_signup_next.setBackgroundColor(resources.getColor(R.color.pumpkinOrange))
                    btn_ac_signup_next.isClickable = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }

        rg_check.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if (edtLoginNum.text.toString() == "" ||
                    edtLoginBir.text.toString() == "" ||
                    edtLoginName.text.toString() == "" ||
                    edtLoginPW.text.toString() == "" ||
                    edtLoginID.text.toString() == "" ||
                    rg_check.checkedRadioButtonId == -1
                ) {
                    btn_ac_signup_next.setBackgroundColor(resources.getColor(R.color.blueGrey))
                    btn_ac_signup_next.isClickable = false
                } else {
                    btn_ac_signup_next.setBackgroundColor(resources.getColor(R.color.pumpkinOrange))
                    btn_ac_signup_next.isClickable = true
                }
            }
        })

        //뒤로 가기 버튼(장바구니로 다시 가야함)--수정 필요
        ic_toolbar_back.setOnClickListener {
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            startActivity(intent)
            finish()
        }


        edtLoginID.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                clearFieldNameColor()
                txtLoginID.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }
        })
        edtLoginPW.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                clearFieldNameColor()
                txtLoginPw.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }
        })
        edtLoginName.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                clearFieldNameColor()
                txtLoginName.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }
        })
        edtLoginBir.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                clearFieldNameColor()
                txtLoginBir.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }
        })
        edtLoginNum.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                clearFieldNameColor()
                txtLoginNum.setTextColor(resources.getColor(R.color.pumpkinOrange))
            }
        })
        edtLoginID.addTextChangedListener(textChangeListener)
        edtLoginPW.addTextChangedListener(textChangeListener)
        edtLoginName.addTextChangedListener(textChangeListener)
        edtLoginBir.addTextChangedListener(textChangeListener)
        edtLoginNum.addTextChangedListener(textChangeListener)


        //로그인하기 클릭 리스너
        btn_ac_signup.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        //다음 클릭 리스너
        btn_ac_signup_next.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()
            val login_u_name: String = edtLoginName.text.toString()
            val login_u_bir: String = edtLoginBir.text.toString()
            val login_u_num: String = edtLoginNum.text.toString()
            var gendercheck: String = "0"
            if (rg_check.check1.isChecked() == true) {
                gendercheck= "0"
            } else{
                gendercheck= "1"
            }

            //비어있으면 계속 요청하는 코드
            if (login_u_id == "") edtLoginID.requestFocus()
            else if (login_u_pw == "") edtLoginPW.requestFocus()
            else if (login_u_name == "") edtLoginName.requestFocus()
            else if (login_u_bir == "") edtLoginBir.requestFocus()
            else if (login_u_num == "") edtLoginNum.requestFocus()
            //값을 하나 더 넘겨주어야함(gendercheck)
            else postLoginResponse(login_u_id, login_u_pw, login_u_name, login_u_bir, login_u_num, gendercheck)
        }

    }

    fun clearFieldNameColor() {
        txtLoginID.setTextColor(resources.getColor(R.color.black))
        txtLoginPw.setTextColor(resources.getColor(R.color.black))
        txtLoginName.setTextColor(resources.getColor(R.color.black))
        txtLoginBir.setTextColor(resources.getColor(R.color.black))
        txtLoginNum.setTextColor(resources.getColor(R.color.black))
    }

//    //공백인 것을 확인하고, 공백일 때는 버튼의 배경이 회색이고, 공백이 아닐때는 버튼의 배경이 주황이다.
//    fun checkempty(){
//        val login_u_id = edtLoginID.text.toString()
//        val login_u_pw: String = edtLoginPW.text.toString()
//        val login_u_name: String = edtLoginName.text.toString()
//        val login_u_bir: String = edtLoginBir.text.toString()
//        val login_u_num: String = edtLoginNum.text.toString()
//
//        if(login_u_id =="" && login_u_pw == "" && login_u_name=="" &&login_u_bir == "" && login_u_num == "" ){
//            btn_ac_signup_next.setBackgroundResource(R.color.blueGrey)
//        }
//        else {btn_ac_signup_next.setBackgroundResource(R.color.pumpkinOrange)}
//    }

    fun postLoginResponse(
        email: String,
        password: String,
        name: String,
        birth: String,
        phone: String,
        gender: String
    ) {
        val intent: Intent = Intent(this, SignupCartActivity::class.java)
        intent.putExtra("loginName", edtLoginName.text.toString())
        intent.putExtra("loginNum", edtLoginNum.text.toString())
        intent.putExtra("email", edtLoginID.text.toString())
        intent.putExtra("phone", edtLoginNum.text.toString())
        intent.putExtra("password", edtLoginPW.text.toString())
        intent.putExtra("birth", edtLoginBir.text.toString())
        intent.putExtra("gender", gender)
        //intent.putExtra("gender", gender)
            Log.e("myTag", "SignupActivity:" + edtLoginID.text.toString())
                    startActivity (intent)
    }
}