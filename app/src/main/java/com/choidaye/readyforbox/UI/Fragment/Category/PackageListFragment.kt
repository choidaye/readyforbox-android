package com.choidaye.readyforbox.UI.Fragment.Category


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Packages
import com.choidaye.readyforbox.Get.GetProductPackageListResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.PackageRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_package_list.*
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PackageListFragment : Fragment() {


    var result : String = ""
    var packageList = ArrayList<Packages>()



    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    lateinit var packageRecyclerViewAdapter: PackageRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_package_list, container, false)

        Log.v("oncreate","온크리에이트가 안돼요")
    }


    override  fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
        setOnBtnClickListener()


        val extra = arguments

        //툴바 이름 바꾸기
//        toolbar_delivery_list_title.text= extra!!.getString("name")

        setProductPackageList(extra!!.getString("name"))


    }



    private fun setRecyclerView() {

        var packageRecyclcerViewAdapter =PackageRecyclerViewAdapter(activity!!, packageList)
        rv_fg_package_list.adapter = packageRecyclcerViewAdapter
        rv_fg_package_list.layoutManager =  LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


    }


    private  fun clearbuttonTextColor(){
        tv_fg_package_list_appliances.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_area.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_manage.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_special.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_animal.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_dress.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_package_list_sleep.setTextColor(resources.getColor(R.color.darkGrey))
        //tv_fg_pakcage_list_homecafe.setTextColor(resources.getColor(R.color.darkGrey))
    }






    private fun setOnBtnClickListener() {



        btn_fg_package_list_appliances.setOnClickListener {



            clearbuttonTextColor()
            tv_fg_package_list_appliances.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }



        btn_fg_package_list_area.setOnClickListener {


            setProductPackageList(tv_fg_package_list_area.text.toString())
            clearbuttonTextColor()
            tv_fg_package_list_area.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }

        btn_fg_package_list_manage.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_package_list_manage.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


        btn_fg_package_list_special.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_package_list_special.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


        btn_fg_package_list_animal.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_package_list_animal.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


        btn_fg_package_list_dress.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_package_list_dress.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


        btn_fg_package_list_sleep.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_package_list_sleep.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }

        btn_fg_package_list_homecafe.setOnClickListener{

            clearbuttonTextColor()
            tv_fg_pakcage_list_homecafe.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


    }



    private fun setProductPackageList(category_name : String) {

        var getProductPackageListResponse : Call<GetProductPackageListResponse> = networkService.getProductPackageListResponse(category_name,1)
        getProductPackageListResponse.enqueue(object : Callback<GetProductPackageListResponse>{

            override fun onResponse(call: Call<GetProductPackageListResponse>, response: Response<GetProductPackageListResponse>) {


                if (response!!.isSuccessful) {



                    toast(response.body()!!.status.toString())


                    Log.e("clear",packageList.toString())


//                packageRecyclerViewAdapter = PackageRecyclerViewAdapter(context!!, response.body()!!.data!!.packages )

                    var temp: ArrayList<Packages> = response.body()!!.data.packages
                    if (temp.size > 0) {

                        Log.v("response",response.body()!!.status.toString())
                       var position = packageRecyclerViewAdapter.itemCount
                        packageRecyclerViewAdapter.packageList.addAll(temp)
                        packageRecyclerViewAdapter.notifyDataSetChanged()

                    }

                }
                else{
                    Log.v("TAG", "마이페이지 서버 값 전달 실패")
                }
            }
            override fun onFailure(call: Call<GetProductPackageListResponse>?, t: Throwable?) {
                Log.v("TAG", "통신 실패 = " +t.toString())
            }
        })
    }




}

