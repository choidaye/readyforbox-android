package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestCoordinator

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import kotlinx.android.synthetic.main.fragment_delivery.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity


class DeliveryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setOnBtnClickListener()



    }


    //카테고리 메인 프래그먼트를 교체시켜줄겁니다

    fun replaceFragment(fragment: Fragment) {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_fg_category_main, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }


    private fun setOnBtnClickListener() {

        btn_fg_delivery_water.setOnClickListener{

            //프레그만트 교체
            replaceFragment(DeliveryListFragment())


        }

    }


}
