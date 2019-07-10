package com.choidaye.readyforbox.UI.Activity.Order

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import kotlinx.android.synthetic.main.activity_ordercompleted.*

class OrdercompletedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordercompleted)

        btn_home.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
