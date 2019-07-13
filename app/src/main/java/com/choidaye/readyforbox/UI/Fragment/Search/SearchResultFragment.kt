package com.choidaye.readyforbox.UI.Fragment.Search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MyPageDeliveryManangerRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.SearchResultRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_my_page_delivery.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchResultFragment : Fragment() {

    val search : String = ""

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    lateinit var searchResultRecyclerViewAdapter: SearchResultRecyclerViewAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override  fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
        getSearchResultResponse()


    }

    private fun getSearchResultResponse() {


    }

    private fun setRecyclerView() {

//        searchResultRecyclerViewAdapter = SearchResultRecyclerViewAdapter(activity!!,search)
//        rv_fg_my_page_delivery_list.adapter = myPageDeliveryManangerRecyclerViewAdapter
//        rv_fg_my_page_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)


    }


}
