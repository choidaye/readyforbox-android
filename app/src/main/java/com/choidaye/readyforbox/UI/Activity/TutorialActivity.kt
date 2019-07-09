package com.choidaye.readyforbox.UI.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.SliderTutorialPagerAdapter
import kotlinx.android.synthetic.main.activity_tutorial.*

class TutorialActivity : AppCompatActivity() {

    var p0 = Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        setOnClickListener()
        configureMainTab()


        //다음 클릭 리스너-프레그먼트 교환


    }

    private fun setOnClickListener() {

        //건너뛰기 버튼 클릭
        btn_jump.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        btn_home_start.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_next.setOnClickListener{
            vp_main_slider.setCurrentItem(vp_main_slider.currentItem + 1, true)
        }

        vp_main_slider.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                if(p0 == 2){
                    btn_home_start.visibility = View.VISIBLE
                    rl_tutorial_bottom.visibility = View.GONE
                    tl_main_indicator.visibility = View.GONE
                }
                else{
                    btn_home_start.visibility = View.GONE
                    rl_tutorial_bottom.visibility = View.VISIBLE
                    tl_main_indicator.visibility = View.VISIBLE
                }
            }
        })
    }


    fun replaceFragment(fragment: Fragment) {
        this.supportFragmentManager
            .beginTransaction()
            .replace(R.id.vp_main_slider, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    private fun configureMainTab() {
        vp_main_slider.adapter = SliderTutorialPagerAdapter(supportFragmentManager, 3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)

    }
}
//private fun configureMainTab() {
//    vp_main_slider.adapter = SliderMainPagerAdapter(supportFragmentManager, 3)
//    vp_main_slider.offscreenPageLimit=2
//    tl_main_indicator.setupWithViewPager(vp_main_slider)
//
//    val navIndicatorMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.navigation_indicator_main, null,false)
//    tl_main_indicator.getTabAt(0)!!.customView = navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_1) as ImageView
//    tl_main_indicator.getTabAt(1)!!.customView = navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_1) as ImageView
//    tl_main_indicator.getTabAt(2)!!.customView = navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_1) as ImageView
//    }
//}
