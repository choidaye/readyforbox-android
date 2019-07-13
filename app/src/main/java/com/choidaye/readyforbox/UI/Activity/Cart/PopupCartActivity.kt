package com.choidaye.readyforbox.UI.Activity.Cart

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.Sign.SignupCartActivity
import kotlinx.android.synthetic.main.activity_popup_cart.*
import kotlinx.android.synthetic.main.activity_popup_delivery.*

class PopupCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_cart)


        rl_one.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("one", "" + tv_one.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_two.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("two", "" + tv_two.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_three.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("three", "" + tv_three.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_four.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("four", "" + tv_four.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_five.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("five", "" + tv_five.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_six.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("six", "" + tv_six.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_seven.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("seven", "" + tv_seven.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rl_eight.setOnClickListener{
            val intent: Intent = Intent(this, CartActivity::class.java)
            intent.putExtra("eight", "" + tv_eight.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}

