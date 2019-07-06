package com.choidaye.readyforbox.UI.Fragment.Search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.SearchData

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.SearchRecyclcerViewAdapter
import kotlinx.android.synthetic.main.fragment_search_new.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchNewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_new, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var searchList : ArrayList<SearchData> = ArrayList()
        searchList.add(SearchData("삼다수"))
        searchList.add(SearchData("휴지"))
        searchList.add(SearchData("여름이불"))
        searchList.add(SearchData("햇반"))



        var searchRecyclcerViewAdapter = SearchRecyclcerViewAdapter(activity!!,searchList)
        rv_fg_search_list_new.adapter = searchRecyclcerViewAdapter
        rv_fg_search_list_new.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

}
