package com.choidaye.readyforbox.UI.Activity.Mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MypageDeliveryFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_page_delivery_mananger.*

class MyPageDeliveryManangerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page_delivery_mananger)


        configureTopTab()
    }

    private fun configureTopTab() {
      vp_ac_my_page_delivery_manage.adapter = MypageDeliveryFragmentStatePagerAdapter(supportFragmentManager,2)
      tl_ac_my_page_delivery_manage_toptab.setupWithViewPager(vp_ac_my_page_delivery_manage)
      val toptab : View = this.layoutInflater.inflate(R.layout.top_tabbar_ac_my_page_delivery_manage,null,false)

        tl_ac_my_page_delivery_manage_toptab.getTabAt(0)!!.customView = toptab.findViewById(R.id.rl_ac_my_page_delivery_manage_check) as RelativeLayout
        tl_ac_my_page_delivery_manage_toptab.getTabAt(1)!!.customView = toptab.findViewById(R.id.rl_ac_my_page_delivery_manage_modify) as RelativeLayout
    }


}
