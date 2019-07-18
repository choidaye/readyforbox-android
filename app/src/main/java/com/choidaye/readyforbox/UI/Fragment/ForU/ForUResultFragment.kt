package com.choidaye.readyforbox.UI.Fragment.ForU


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.*
import com.choidaye.readyforbox.Get.GetForUResultResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.ForUResultDeliveryRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultHelpRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.ForUResultPackageRecyclerViewAdapter


import kotlinx.android.synthetic.main.fragment_for_u_result.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class ForUResultFragment : Fragment() {




    var forUresultpackageList = ArrayList<Packages>()
    var forUresultdeliveryList = ArrayList<Regularity>()
    var forUresulthelpList = ArrayList<Regular_not_Important>()



    lateinit var forUResultPackageRecyclerViewAdapter : ForUResultPackageRecyclerViewAdapter
    lateinit var forUResultDeliveryRecyclerViewAdapter : ForUResultDeliveryRecyclerViewAdapter
    lateinit var forUResultHelpRecyclerViewAdapter : ForUResultHelpRecyclerViewAdapter




    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_for_u_result, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val extra=arguments

        val type=extra!!.getString("type")
        val first=extra!!.getString("first")
        val second=extra!!.getString("second")
        val fifth=extra!!.getString("fifth")
        val minprice=extra!!.getInt("minprice")
        val maxprice=extra!!.getInt("maxprice")


        fg_for_u_result_type.text=type


        setRecyclerView()
        getForUResultResponse(first,second,fifth,minprice,maxprice)

        /*
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultpackageList.add(ForUResultPackage("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))




        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresultdeliveryList.add(ForUResultDelivery("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))





        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))
        forUresulthelpList.add(ForUResultHelp("삼다수","http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428",17000))





*/
    }

    private fun setRecyclerView() {




        forUResultPackageRecyclerViewAdapter = ForUResultPackageRecyclerViewAdapter(activity!!,forUresultpackageList)
        rv_fg_for_u_ready_for_package.adapter = forUResultPackageRecyclerViewAdapter
        rv_fg_for_u_ready_for_package.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)





        forUResultDeliveryRecyclerViewAdapter = ForUResultDeliveryRecyclerViewAdapter(activity!!,forUresultdeliveryList)
        rv_fg_for_u_ready_for_delivery.adapter = forUResultDeliveryRecyclerViewAdapter
        rv_fg_for_u_ready_for_delivery.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)



        //

        forUResultHelpRecyclerViewAdapter = ForUResultHelpRecyclerViewAdapter(activity!!,forUresulthelpList)
        rv_fg_for_u_ready_for_help.adapter = forUResultHelpRecyclerViewAdapter
        rv_fg_for_u_ready_for_help.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL,false)


    }

    fun getForUResultResponse(first: String, second: String, fifth: String, minprice: Int, maxprice:Int){
        val getForUResultResponse: Call<GetForUResultResponse> = networkService.getForUResultResponse(first,second,fifth,minprice,maxprice)
        getForUResultResponse.enqueue(object: Callback<GetForUResultResponse>{
            override fun onResponse(call: Call<GetForUResultResponse>, response: Response<GetForUResultResponse>) {
                if(response!!.isSuccessful){

                    forUresultpackageList.clear()
                    forUresultdeliveryList.clear()
                    forUresulthelpList.clear()


                    val tmp:ArrayList<Packages> = response.body()!!.data.packages
                    val tmp2:ArrayList<Regularity> = response.body()!!.data.regularity
                    val tmp3:ArrayList<Regular_not_Important> = response.body()!!.data.regular_not_Important


                    if(tmp.size>0) {
                        forUResultPackageRecyclerViewAdapter.forUresultpackageList.addAll(tmp)
                        forUResultPackageRecyclerViewAdapter.notifyDataSetChanged()
                    }
                    //if(tmp2.size>0){
                    //    val position2 = forUResultDeliveryRecyclerViewAdapter.itemCount
                        forUResultDeliveryRecyclerViewAdapter.forUresultDeliveryList.addAll(tmp2)
                        forUResultDeliveryRecyclerViewAdapter.notifyDataSetChanged()
                    //}

                    //if(tmp3.size>0){
                    //    val position3 = forUResultHelpRecyclerViewAdapter.itemCount
                        forUResultHelpRecyclerViewAdapter.forUresultHelpList.addAll(tmp3)
                        forUResultHelpRecyclerViewAdapter.notifyDataSetChanged()
                    //}
                }
                else{
                    Log.e("TAG","전달 실패")
                }
            }

            override fun onFailure(call: Call<GetForUResultResponse>, t: Throwable) {
                Log.e("TAG","통신 실패")
            }
        })
    }
}
