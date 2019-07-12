package com.choidaye.readyforbox.UI.Fragment.Category


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.Get.GetProductDeliveyListResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService

import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Activity.ProductDetailActivity
import com.choidaye.readyforbox.UI.Activity.Cart.CartActivity
import com.choidaye.readyforbox.UI.Activity.PackageActivity
import com.choidaye.readyforbox.UI.Adapter.DeliveryRecyclerViewAdapter
import kotlinx.android.synthetic.main.filter_product_list.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_delivery_list.*
import org.jetbrains.anko.support.v4.startActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DeliveryListFragment : Fragment() {

    var result : String = ""
    var deliveryList = ArrayList<Product>()


    lateinit var  nameList : ArrayList<String>








    lateinit var deliveryRecyclcerViewAdapter: DeliveryRecyclerViewAdapter



    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }










    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery_list, container, false)

        Log.v("oncreate", "온크리에이트가 안돼요")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setRecyclerView()
        setOnBtnClickListener()


        nameList= ArrayList()
//        네임리스트에 카테고리 이름 넣어놓기
        nameList.add("생수/음료").toString()
        nameList.add("세제/섬유유연제").toString()
        nameList.add("욕실용품").toString()
//       name.add("휴지/물티슈").toString()
//        name.add("청소물품").toString()
//        name.add("디퓨저/방향제").toString()
//
//



        //툴바 이름 바꾸기
//        toolbar_delivery_list_title.text= extra!!.getString("name")

        val extra = arguments
        setProductDeliveyList(extra!!.getString("name"),1)




        if(extra!!.getString("name").equals("생수/음료")) tv_fg_delivery_list_water.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("세제/섬유유연제")) tv_fg_delivery_list_detergent.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("욕실용품")) tv_fg_delivery_list_bathroom.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("휴지/물티슈")) tv_fg_delivery_list_tissue.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("청소용품")) tv_fg_delivery_list_clean.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("주방용품")) tv_fg_delivery_list_cook.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("디퓨저/방향제")) tv_fg_delivery_list_defuser.setTextColor(resources.getColor(R.color.pumpkinOrange))
        else if(extra!!.getString("name").equals("반려동물용품")) tv_fg_delivery_list_animal.setTextColor(resources.getColor(R.color.pumpkinOrange))




    }

    //리사이클러뷰어댑터

    private fun setRecyclerView() {
        deliveryRecyclcerViewAdapter = DeliveryRecyclerViewAdapter(activity!!, deliveryList){ Product ->
            startActivity<ProductDetailActivity>()
        }
        rv_fg_delivery_list.adapter = deliveryRecyclcerViewAdapter
        rv_fg_delivery_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }



    private  fun clearbuttonTextColor(){
        tv_fg_delivery_list_water.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_detergent.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_tissue.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_bathroom.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_defuser.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_cook.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_clean.setTextColor(resources.getColor(R.color.darkGrey))
        tv_fg_delivery_list_animal.setTextColor(resources.getColor(R.color.darkGrey))
    }


    private fun setOnBtnClickListener() {


        btn_toolbar_cart_delivery_list.setOnClickListener{
            startActivity<CartActivity>()
        }

        btn_fg_delivery_list_filter_choice.setOnClickListener{

            //필터 다이얼로그로 이동
            showProductListFilter()

        }






        btn_fg_delivery_list_water.setOnClickListener {


            setProductDeliveyList(tv_fg_delivery_list_water.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_water.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }



        btn_fg_delivery_list_detergent.setOnClickListener {

            setProductDeliveyList(tv_fg_delivery_list_detergent.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_detergent.setTextColor(resources.getColor(R.color.pumpkinOrange))


        }


        btn_fg_delivery_list_tissue.setOnClickListener {

            setProductDeliveyList(tv_fg_delivery_list_tissue.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_tissue.setTextColor(resources.getColor(R.color.pumpkinOrange))

        }


        btn_fg_delivery_list_clean.setOnClickListener {
            //툴바 이름 바꾸기
            //toolbar_delivery_list_title.text = tv_fg_delivery_lsit_clean.text

            setProductDeliveyList(tv_fg_delivery_list_clean.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_clean.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }


        btn_fg_delivery_list_animal.setOnClickListener {

            setProductDeliveyList(tv_fg_delivery_list_animal.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_animal.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }


        btn_fg_delivery_list_cook.setOnClickListener {

            setProductDeliveyList(tv_fg_delivery_list_cook.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_cook.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }



        btn_fg_delivery_list_defuser.setOnClickListener {


            setProductDeliveyList(tv_fg_delivery_list_defuser.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_defuser.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }

        btn_fg_delivery_list_bathroom.setOnClickListener {



            setProductDeliveyList(tv_fg_delivery_list_bathroom.text.toString(),1)
            clearbuttonTextColor()
            tv_fg_delivery_list_bathroom.setTextColor(resources.getColor(R.color.pumpkinOrange))
        }



    }


    private fun showProductListFilter() {

        Log.v("filter","최신순 인기순 등 필터")
        var productListFilter = Dialog(activity!!)
        productListFilter.setCancelable(true)

        val productListFilterDialog = activity!!.layoutInflater.inflate(R.layout.filter_product_list, null)
        productListFilter.setContentView(productListFilterDialog )


//
//        productListFilter.rb_filter_product_list_new.text = result[0]!!.
//        productListFilter.rb_filter_product_list_famous.text = temp[1]!!.name
//        productListFilter.rb_filter_product_list_cheap.text = temp[2]!!.name




        productListFilter.rb_filter_product_list_new.setOnCheckedChangeListener { buttonView, isChecked ->

            result =  productListFilter.rb_filter_product_list_new.text.toString()!!
            tv_fg_delivery_list_filter_title.text = result

            setProductDeliveyList( nameList.toString(),1)
            Log.v("namelist",nameList.toString())



            productListFilter.dismiss()


        }



        productListFilter.rb_filter_product_list_famous.setOnCheckedChangeListener { buttonView, isChecked ->


            result = productListFilter.rb_filter_product_list_famous.text.toString()!!
            tv_fg_delivery_list_filter_title.text = result
          //  setProductDeliveyList(category_name.toString(),2)
            productListFilter.dismiss()
        }


        productListFilter.rb_filter_product_list_cheap.setOnCheckedChangeListener { buttonView, isChecked ->


            result = productListFilter.rb_filter_product_list_cheap.text.toString()!!
            tv_fg_delivery_list_filter_title.text = result

            setProductDeliveyList( nameList.toString(),3)
            productListFilter.dismiss()
        }



        productListFilter.rb_filter_product_list_expansive.setOnCheckedChangeListener { buttonView, isChecked ->


            result = productListFilter.rb_filter_product_list_expansive.text.toString()!!
            tv_fg_delivery_list_filter_title.text = result

         //   setProductDeliveyList(category_name.toString(),4)

            productListFilter.dismiss()
        }


        productListFilter.show()

    }



    fun setProductDeliveyList(category_name : String, flag : Int){



        var getProductDeliveyList: Call<GetProductDeliveyListResponse> = networkService.getProductDeliveryListResponse(category_name,flag)
        getProductDeliveyList.enqueue(object : Callback<GetProductDeliveyListResponse> {
            override fun onResponse(call: Call<GetProductDeliveyListResponse>?, response: Response<GetProductDeliveyListResponse>?) {

                if (response!!.isSuccessful) {
                    deliveryList.clear()


                    var temp: ArrayList<Product> = response.body()!!.data.product
                    if (temp.size > 0) {
                        val position = deliveryRecyclcerViewAdapter.itemCount
                        deliveryRecyclcerViewAdapter.deliveryList.addAll(temp)
                        deliveryRecyclcerViewAdapter.notifyDataSetChanged()

                    }

                }
                else{
                    Log.v("TAG", "서버 값 전달 실패")
                }
            }

            override fun onFailure(call: Call<GetProductDeliveyListResponse>?, t: Throwable?) {
                Log.v("TAG", "통신 실패 = " +t.toString())
            }
        })
    }




}


