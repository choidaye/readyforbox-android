package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.choidaye.readyforbox.R
import kotlinx.android.synthetic.main.fragment_delivery.*
import kotlinx.android.synthetic.main.fragment_package.*
import kotlinx.android.synthetic.main.fragment_package_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PackageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_package, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setOnBtnClickListener()



    }


    //카테고리 메인 프래그먼트를 교체시켜줄겁니다

    fun replaceFragment(fragment: Fragment,name: String) {
        val packagelistFragment =PackageListFragment()
        val bundle = Bundle()

        bundle.putString("name",name)
        packagelistFragment.arguments = bundle

        var trans = activity!!.supportFragmentManager.beginTransaction()
        trans.replace(R.id.fl_fg_category_main,packagelistFragment)
        trans.addToBackStack(fragment.javaClass.simpleName)
        trans.commit()
    }


    private fun setOnBtnClickListener() {
        btn_fg_package_area.setOnClickListener{

            replaceFragment(PackageListFragment(),tv_fg_package_area.text.toString())


        }

    }


}
