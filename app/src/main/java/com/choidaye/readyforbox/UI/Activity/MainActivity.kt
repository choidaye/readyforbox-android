package com.choidaye.readyforbox.UI.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MainFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureBottomNavigation()
    }

    private fun configureBottomNavigation() {
        vp_ac_main_frag_pager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager, 5)
        tl_ac_main_bottomTab.setupWithViewPager(vp_ac_main_frag_pager)
        val bottomNaviLayout: View = this.layoutInflater.inflate(R.layout.bottom_navigation_tab, null, false)

        tl_ac_main_bottomTab.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_home_tab) as RelativeLayout
        tl_ac_main_bottomTab.getTabAt(1)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_category_tab) as RelativeLayout
        tl_ac_main_bottomTab.getTabAt(2)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_search_tab) as RelativeLayout
        tl_ac_main_bottomTab.getTabAt(3)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_forU_tab) as RelativeLayout
        tl_ac_main_bottomTab.getTabAt(4)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_my_box_tab) as RelativeLayout
    }

}
