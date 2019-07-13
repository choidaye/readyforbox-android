package com.choidaye.readyforbox.UI.Activity.Sign

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_popup_delivery.*
import kotlinx.android.synthetic.main.activity_signup_cart.*

class PopupDeliveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_delivery)

        rl_door.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("door", "" + tv_door.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Log.e("myTag", ""+ tv_door.text.toString())
            finish()
        }
        rl_security_office.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("securityoffice", "" + tv_security.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Log.e("myTag", ""+ tv_security.text.toString())
            finish()
        }
        rl_courier.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("courier", "" + tv_courier.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Log.e("myTag", ""+ tv_courier.text.toString())
            finish()
        }
        rl_self.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("self", "" + tv_self.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Log.e("myTag", ""+ tv_self.text.toString())
            finish()
        }
        rl_other.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("other", "" + tv_other.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Log.e("myTag", ""+ tv_other.text.toString())
            finish()
        }
    }
}
