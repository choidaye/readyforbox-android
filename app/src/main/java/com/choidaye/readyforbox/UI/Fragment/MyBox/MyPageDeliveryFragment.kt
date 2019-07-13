package com.choidaye.readyforbox.UI.Fragment.MyBox


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Data.Regular
import com.choidaye.readyforbox.Get.GetMyboxDeliveryResponse
import com.choidaye.readyforbox.Get.MypageDelivery
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.MyPageDeliveryManangerRecyclerViewAdapter
import com.choidaye.readyforbox.UI.Adapter.PackageDetailRecyclcerViewAdapter
import kotlinx.android.synthetic.main.fragment_my_page_delivery.*
import kotlinx.android.synthetic.main.rv_item_ac_my_page_delivery_check_product.*
import org.jetbrains.anko.image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MyPageDeliveryFragment : Fragment() {


    var token : String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo5LCJuYW1lIjoiPz8_IiwiZW1haWwiOiJkYXllQG5hdmVyLmNvbSIsImlhdCI6MTU2Mjk4ODMxNCwiZXhwIjoxNTY0MTk3OTE0LCJpc3MiOiJqYWVzZW9uZyJ9.YgcyZXP4ukZOmqPZu6Ybiy4-u64EhpgY5Bzu7Kv9Jn8"

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    lateinit var myPageDeliveryManangerRecyclerViewAdapter: MyPageDeliveryManangerRecyclerViewAdapter

    var mypageDeliverylist = ArrayList<Regular>()

    var name : String = ""
    var content : String = ""
    var count : Int = 0
    var saled_price : Int = 0
    var is_subscribed : Int = 0
    var delivery_day : Int = 0






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page_delivery, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
       getMyPagedeliveryResponse(token)

    }

    private fun getMyPagedeliveryResponse(token : String) {



        var getMyPageDeliveryResponse = networkService.getMypageDelivery(token)
        getMyPageDeliveryResponse.enqueue(object : Callback<GetMyboxDeliveryResponse>{



            override fun onResponse(call: Call<GetMyboxDeliveryResponse>, response: Response<GetMyboxDeliveryResponse>) {

                if (response.isSuccessful){

                    Log.v("response", response.message())
                    Log.v("status", response.body().toString())

                    val position = ArrayList<Regular>().size
                    var regulardata = response.body()!!.data.regular



                    var temp: ArrayList<Regular> = response.body()!!.data.regular


                    mypageDeliverylist.clear()
                    myPageDeliveryManangerRecyclerViewAdapter.mypageDeliveryList.addAll(temp)
                    myPageDeliveryManangerRecyclerViewAdapter.notifyDataSetChanged()



                   // setMyDeliveryView(delivery_day,delivery_day,name,count)



                }
                else{

                    Log.v("response data", "서버 값 전달 오류")



                }


            }

            override fun onFailure(call: Call<GetMyboxDeliveryResponse>, t: Throwable) {

                Log.e("My Delivery fail",t.toString())

            }
        })
    }


    private fun setRecyclerView(){

        myPageDeliveryManangerRecyclerViewAdapter = MyPageDeliveryManangerRecyclerViewAdapter(activity!!,mypageDeliverylist)
        rv_fg_my_page_delivery_list.adapter = myPageDeliveryManangerRecyclerViewAdapter
        rv_fg_my_page_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)


    }

//
//    private fun setMyDeliveryView(delivery_cycle : Int, delivery_day : Int, name :String, count : Int ){
//
//            delivery_cycle?.let{
//
//                tv_ac_my_page_delivery_check_product_term.text  = delivery_cycle.toString()
//
//            }
//
//            delivery_day?.let{
//
//                tv_ac_my_page_delivery_check_product_date.text = delivery_day.toString()
//
//
//            }
//
//            name?.let{
//
//                tv_ac_my_page_delivery_check_product_name.text = name
//
//
//            }
//
//            count?.let{
//                tv_ac_my_page_delivery_check_product_num.text = count.toString()
//            }
//




   // }





}
