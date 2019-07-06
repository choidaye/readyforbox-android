package com.choidaye.readyforbox.UI.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.choidaye.readyforbox.UI.Fragment.Search.SearchNewFragment
import com.choidaye.readyforbox.UI.Fragment.Search.SearchRecommendFragment

class SearchFragmentStatePagerAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return SearchNewFragment()
            1 -> return SearchRecommendFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}