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
import android.widget.RadioGroup
import android.widget.Toast
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import com.choidaye.readyforbox.UI.Activity.WebviewActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.ic_toolbar_back
import kotlinx.android.synthetic.main.activity_signup_cart.*
import org.jetbrains.anko.db.NULL
import org.jetbrains.anko.networkStatsManager
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import com.choidaye.readyforbox.Post.PostSignupResponse as PostSignupResponse

class SignupCartActivity : AppCompatActivity() {

    val networkService : NetworkService by lazy{
        ApplicationController.instance.networkService
    }

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
        val email: String = intent.getStringExtra("email")
        val password: String = intent.getStringExtra("password")
        val birth: String = intent.getStringExtra("birth")
        val phone: String = intent.getStringExtra("phone")
        val gender: String = intent.getStringExtra("gender")


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
                }else {
                    Log.e("test", ""+btn_ac_signup_nextcom.isClickable())
                    btn_ac_signup_nextcom.setBackgroundColor(resources.getColor(R.color.pumpkinOrange))
                    btn_ac_signup_nextcom.isClickable = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }

        fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
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
            val delivery_memo=edtLogindelivery.text.toString()

            val CartNum = cart_num1+cart_num2+cart_num3
            Log.e("CartNum",""+CartNum)

            if (cart_name == "") edtCartName.requestFocus()
            else if (cart_num1 == "") edtCartNum1.requestFocus()
            else if (cart_num2 == "") edtCartNum2.requestFocus()
            else if (cart_num3 == "") edtCartNum3.requestFocus()
            else if (address_num == "") edtAddressNum.requestFocus()
            else if (address == "") edtAddress.requestFocus()
            else if (address_detail == "") edtAddressdetail.requestFocus()
            else {
                Log.e("test", ""+btn_ac_signup_nextcom.isClickable())
                btn_ac_signup_nextcom.setBackgroundColor(resources.getColor(R.color.pumpkinOrange))
                postSignupResponse(email, password, cart_name, birth, phone, gender, cart_name, CartNum, address_num, address, address_detail, delivery_memo )
            }
        }
        img_popup.setOnClickListener {
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
        email: String,
        password: String,
        name: String,
        birth:String,
        phone:String,
        gender:String,
        receiver: String,
        receiver_phone: String,
        address_num: String,
        address: String,
        address_detail: String,
        delivery_memo: String
    ) {
        var jsonObject=JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("password", password)
        jsonObject.put("name", name)
        jsonObject.put("birth", birth)
        jsonObject.put("phone", phone)
        jsonObject.put("gender", gender)
        jsonObject.put("receiver", receiver)
        jsonObject.put("receiver_phone", receiver_phone)
        jsonObject.put("address1", address_num)
        jsonObject.put("address2", address)
        jsonObject.put("address_detail", address_detail)
        jsonObject.put("delivery_memo", delivery_memo)

        val gsonObject=JsonParser().parse(jsonObject.toString()) as JsonObject
        val postSignupResponse: Call<PostSignupResponse> =
        networkService.postSignupResponse("application/json", gsonObject)
        postSignupResponse.enqueue(object : Callback<PostSignupResponse>{
            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                Log.e("Signup failed", t.toString())
            }

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                if(response.isSuccessful){
                    if(response.body()!!.status==201){
//                        val simpleDataFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//                        val e_time=simpleDataFormat.format(Date())
//
//                        val intent:Intent=Intent()
//                        intent.putExtra("end_time", e_time)
                        startActivity<MainActivity>()
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                        Log.e("Signup", response.body().toString())
                    }
                    else{
                        Log.v("response data", "서버 값 전달 실패")
                    }
                }
            }
        })

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
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                //val values: String? = data!!.getStringExtra("values")
                val door: String? = data!!.getStringExtra("door")
                Log.e("myTag", "" + door)
                val securityoffice: String? = data!!.getStringExtra("securityoffice")
                Log.e("myTag", "" + securityoffice)
                val courier: String? = data!!.getStringExtra("courier")
                Log.e("myTag", "" + courier)
                val self: String? = data!!.getStringExtra("self")
                Log.e("myTag", "" + self)
                val other: String? = data!!.getStringExtra("other")
                Log.e("myTag", "" + other)


                if (door != null) edtLogindelivery.setText(door)
                else if (securityoffice != null) edtLogindelivery.setText(securityoffice)
                else if (courier != null) edtLogindelivery.setText(courier)
                else if (self != null) edtLogindelivery.setText(self)
                else edtLogindelivery.setText(other)
            }
        }
    }

}