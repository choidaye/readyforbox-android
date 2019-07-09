package com.choidaye.readyforbox.UI.Activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intent = Intent(this,TutorialActivity::class.java)
//        startActivity(intent)
//        finish()

        Handler().postDelayed({
            startActivity<TutorialActivity>()
            finish()
        }, 4000)
    }
}