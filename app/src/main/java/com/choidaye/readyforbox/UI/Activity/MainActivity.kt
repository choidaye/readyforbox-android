package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.widget.RelativeLayout
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MainFragmentStatePagerAdapter
import com.choidaye.readyforbox.UI.Fragment.Category.DeliveryListFragment
import com.choidaye.readyforbox.UI.Fragment.ForU.ForUResultFragment
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val forUResultFragment=ForUResultFragment()
        val args=Bundle()
        var type: String=data!!.getStringExtra("name")
        args.putString("type",type)
        forUResultFragment.arguments=args
        var translate = supportFragmentManager.beginTransaction()
        translate.replace(R.id.main_layout,forUResultFragment)
        translate.addToBackStack(forUResultFragment.javaClass.simpleName)
        translate.commit()

//        replaceFragment(ForUResultFragment())
    }

    /*
    fun replaceFragment(Fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.vp_ac_main_frag_pager,Fragment, Fragment.javaClass.simpleName)
            .addToBackStack(Fragment.javaClass.simpleName)
            .commit()
    }
    */
}
