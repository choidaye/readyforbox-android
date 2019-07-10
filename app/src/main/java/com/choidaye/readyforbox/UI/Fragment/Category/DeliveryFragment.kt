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
import kotlinx.android.synthetic.main.fragment_delivery_list.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


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

    fun replaceFragment(fragment: Fragment,name: String) {
        val deliverylistFragment = DeliveryListFragment()
        val bundle = Bundle()

        bundle.putString("name",name)
         deliverylistFragment.arguments = bundle

        var translate = activity!!.supportFragmentManager.beginTransaction()
        translate.replace(R.id.fl_fg_category_main,deliverylistFragment)
       translate.addToBackStack(fragment.javaClass.simpleName)
        translate.commit()

//            .replace(R.id.fl_fg_category_main, fragment, fragment.javaClass.simpleName)
//            .addToBackStack(fragment.javaClass.simpleName)
//            .commit()



    }


    private fun setOnBtnClickListener() {

        btn_fg_delivery_water.setOnClickListener{

            //toast(tv_fg_delivery_water.text.toString()).show()
            //프레그만트 교체
         replaceFragment(DeliveryListFragment(),tv_fg_delivery_water.text.toString())

        }


        btn_fg_delivery_detergent.setOnClickListener {
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_detergent.text.toString())

        }


        btn_fg_delivery_bathroom.setOnClickListener {
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_bathroom.text.toString())

        }

        btn_fg_delivery_tissue.setOnClickListener {
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_tissue.text.toString())

        }

        btn_fg_delivery_detergent.setOnClickListener {
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_detergent.text.toString())

        }
        btn_fg_delivery_clean.setOnClickListener {
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_clean.text.toString())

        }
        btn_fg_delivery_cook.setOnClickListener{
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_cook.text.toString())

        }
        btn_fg_delivery_defuser.setOnClickListener{
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_defuser.text.toString())

        }
        btn_fg_delivery_animal.setOnClickListener{
            replaceFragment(DeliveryListFragment(),tv_fg_delivery_animal.text.toString())

        }


    }


}
