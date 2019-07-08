package com.choidaye.readyforbox.UI.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.SliderHomePagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var p0 = Int

    //레이아웃
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
    //프래그먼트에서 기능을 할때 한번 더 오버라이드
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureBanner()
    }

    fun replaceFragment(fragment: Fragment) {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.vp_main_slider, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    //프래그먼트 안에 프래그먼트 있을때 supportFragment를 쓰는게 아니라 chlidFragmentManager를 쓴다.
    private fun configureBanner() {
        vp_home_slider.adapter = SliderHomePagerAdapter(childFragmentManager, 4)
        vp_home_slider.offscreenPageLimit = 3
        tl_home_indicator.setupWithViewPager(vp_home_slider)

    }
}

