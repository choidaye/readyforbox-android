package com.choidaye.readyforbox.UI.Fragment.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.fragment_slider_home.*

class SliderHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_home, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val img_url: Int = arguments!!.getInt("background_url")

        Glide.with(this)
            .load(img_url)
            .into(img_fragment_slider_home)
    }

}