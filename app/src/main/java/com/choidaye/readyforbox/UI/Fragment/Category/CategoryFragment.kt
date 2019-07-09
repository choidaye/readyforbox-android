package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.Cart.CartActivity
import com.choidaye.readyforbox.UI.Adapter.CategoryFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 *
 */
class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setOnBtnClickListener()

        configureToptab()
    }


    private fun configureToptab() {
        vp_fg_category_product.adapter = CategoryFragmentStatePagerAdapter(childFragmentManager, 2)
        tl_fg_category_toptab.setupWithViewPager(vp_fg_category_product)
        val topTabLayout: View = activity!!.layoutInflater.inflate(R.layout.top_tabbar_fg_category, null, false)

        tl_fg_category_toptab.getTabAt(0)!!.customView = topTabLayout.findViewById(R.id.rl_fg_category_delivery) as RelativeLayout
        tl_fg_category_toptab.getTabAt(1)!!.customView = topTabLayout.findViewById(R.id.rl_fg_category_package) as RelativeLayout
    }

    private fun setOnBtnClickListener() {
        btn_toolbar_cart.setOnClickListener {
            startActivity<CartActivity>()
        }

    }



}
