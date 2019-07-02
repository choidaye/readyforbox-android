package com.choidaye.readyforbox.UI.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.choidaye.readyforbox.UI.Fragment.Category.CategoryFragment
import com.choidaye.readyforbox.UI.Fragment.ForU.ForUFragment
import com.choidaye.readyforbox.UI.Fragment.Home.HomeFragment
import com.choidaye.readyforbox.UI.Fragment.MyBox.MyBoxFragment
import com.choidaye.readyforbox.UI.Fragment.Search.SearchFragment


class MainFragmentStatePagerAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return HomeFragment()
            1 -> return CategoryFragment()
            2 -> return SearchFragment()
            3 -> return ForUFragment()
            4 -> return MyBoxFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}