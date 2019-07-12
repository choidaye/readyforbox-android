package com.choidaye.readyforbox.UI.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.MainActivity
import com.choidaye.readyforbox.UI.Activity.ProductDetailActivity
import com.choidaye.readyforbox.UI.Fragment.Category.PackageFragment
import com.choidaye.readyforbox.UI.Fragment.Category.PackageListFragment
import kotlinx.android.synthetic.main.fragment_package.*
import kotlinx.android.synthetic.main.fragment_slider_home.*
import org.jetbrains.anko.support.v4.startActivity

class SliderHomeFragment : Fragment() {
    private var packageFragment: PackageFragment? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // packageFragment = PackageFragment()
        return inflater.inflate(R.layout.fragment_slider_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val img_url: Int = arguments!!.getInt("background_url")
//        val idx : Int = arguments!!.getInt("idx")
//
//        if(idx == 0){
//            (activity as MainActivity).supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.vp_ac_main_frag_pager, packageFragment!!);
//        }


        Glide.with(this)
            .load(img_url)
            .into(img_fragment_slider_home)

        img_fragment_slider_home.setOnClickListener {
            if(arguments!!.getInt("background_url") == R.drawable.banne_img_1){
                //이동하고 싶은 액티비티로 이동
                startActivity<ProductDetailActivity>()

            }
            else if(arguments!!.getInt("background_url") == R.drawable.banne_img_2){
                startActivity<ProductDetailActivity>()
            }
            else if(arguments!!.getInt("background_url") == R.drawable.banne_img_3){
                startActivity<ProductDetailActivity>()
            }
            else if(arguments!!.getInt("background_url") == R.drawable.banne_img_4){
                startActivity<ProductDetailActivity>()
            }
    }
    }
}