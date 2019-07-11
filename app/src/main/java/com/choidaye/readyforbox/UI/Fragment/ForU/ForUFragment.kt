package com.choidaye.readyforbox.UI.Fragment.ForU


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.ForUSettingActivity
import com.choidaye.readyforbox.UI.Activity.PackageActivity
import com.choidaye.readyforbox.UI.Activity.ProductDetailActivity
import kotlinx.android.synthetic.main.fragment_for_u.*
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ForUFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_u, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_only_setting.setOnClickListener {
            startActivity<ForUSettingActivity>()
        }
    }
}
