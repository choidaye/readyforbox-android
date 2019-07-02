package com.choidaye.readyforbox.UI.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.choidaye.readyforbox.UI.Fragment.Category.DeliveryFragment
import com.choidaye.readyforbox.UI.Fragment.Category.PackageFragment

class CategoryFragmentStatePagerAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return DeliveryFragment()
            1 -> return PackageFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount // 자바에서는 { return fragmentCount }

}