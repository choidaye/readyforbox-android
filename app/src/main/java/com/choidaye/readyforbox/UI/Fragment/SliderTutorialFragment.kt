package com.choidaye.readyforbox.UI.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.fragment_slider_tutorial.*


class SliderTutorialFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_tutorial, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //val color:Int = arguments!!.getInt("background_color")
        val img_url: Int = arguments!!.getInt("background_url")

        //img_fragment_slider_main.setBackgroundColor(color)
        Glide.with(this)
            .load(img_url)
            .into(img_fragment_slider_tutorial)
    }
}