package com.choidaye.readyforbox.UI.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.choidaye.readyforbox.UI.Fragment.Category.DeliveryFragment
import com.choidaye.readyforbox.UI.Fragment.Category.PackageFragment
import com.choidaye.readyforbox.UI.Fragment.MyBox.MyPageDeliveryFragment
import com.choidaye.readyforbox.UI.Fragment.MyBox.MyPagePayModifyFragment

class MypageDeliveryFragmentStatePagerAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return MyPageDeliveryFragment()
            1 -> return MyPagePayModifyFragment()
            else -> return null
        }

    }

    override fun getCount(): Int = fragmentCount

}