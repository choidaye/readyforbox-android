package com.choidaye.readyforbox.UI.Adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Fragment.Home.SliderHomeFragment

class SliderHomePagerAdapter(fm: FragmentManager?, val num_fragment: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        var fragment: SliderHomeFragment = SliderHomeFragment()
        var bundle: Bundle = Bundle(1)
        when (p0) {
            0 -> bundle.putInt("background_url", R.drawable.banne_img_1)
            1 -> bundle.putInt("background_url", R.drawable.banne_img_2)
            2 -> bundle.putInt("background_url", R.drawable.banne_img_3)
            3 -> bundle.putInt("background_url", R.drawable.banne_img_4)
        }
        fragment.arguments=bundle
        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}