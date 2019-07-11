package com.choidaye.readyforbox.UI.Activity.Sign

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_popup_delivery.*

class PopupDeliveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_delivery)

        rl_door.setOnClickListener{
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("door", "" + tv_door.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
