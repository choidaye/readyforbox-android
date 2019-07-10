package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebSettings
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.activity_webview.*


class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        postView.setCallback { zoneCode, address, buildingName ->
            val intent: Intent = Intent(this, SignupCartActivity::class.java)
            intent.putExtra("zoneCode", "" + zoneCode)
            Log.e("myTag", "WebviewActivity: "+ zoneCode)
            setResult(Activity.RESULT_OK, intent);
            finish()
        }
        postView.setPostUrl("https://windsekirun.github.io/DaumPostCodeView/")
        postView.startLoad()
    }
}

