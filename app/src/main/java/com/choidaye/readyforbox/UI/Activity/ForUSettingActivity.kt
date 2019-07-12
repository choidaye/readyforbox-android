package com.choidaye.readyforbox.UI.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.widget.LinearLayout
import com.choidaye.readyforbox.Data.DragAndDrop
import com.choidaye.readyforbox.DragListener.*
import com.choidaye.readyforbox.Get.GetForUResultResponse
import com.choidaye.readyforbox.Network.ApplicationController
import com.choidaye.readyforbox.Network.NetworkService
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.DragListRecyclcerViewAdapter
import kotlinx.android.synthetic.main.activity_for_usetting.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForUSettingActivity : AppCompatActivity(), OnStartDragListener {
    lateinit var dragListRecyclcerViewAdapter: DragListRecyclcerViewAdapter
    lateinit var touchHelper: ItemTouchHelper

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_usetting)


        var dataList: ArrayList<DragAndDrop> = ArrayList()
        var dataList2: ArrayList<DragAndDrop> =ArrayList()

        dataList.add(DragAndDrop("청소","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList.add(DragAndDrop("요리","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList.add(DragAndDrop("수면","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList.add(DragAndDrop("인테리어","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList.add(DragAndDrop("옷 관리","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))

        dataList2.add(DragAndDrop("청소","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList2.add(DragAndDrop("요리","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList2.add(DragAndDrop("수면","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList2.add(DragAndDrop("인테리어","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))
        dataList2.add(DragAndDrop("옷 관리","http://codetheory.in/wp-content/uploads/2016/09/Screen-Shot-2016-09-23-at-12.40.41-PM.png"))


        dragListRecyclcerViewAdapter=DragListRecyclcerViewAdapter(applicationContext!!,dataList,this)
        lt_setting_all.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        var callback: ItemTouchHelper.Callback= DragItemTouchHelperCallback(dragListRecyclcerViewAdapter)
        touchHelper= ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(lt_setting_all)

        lt_setting_all.adapter=dragListRecyclcerViewAdapter

        sb_range.setOnRangeSeekbarChangeListener { min, max ->
            txt_setting_priceMin.setText(min.toString())
            txt_setting_priceMax.setText(max.toString())
        }
        sb_range.setOnRangeSeekbarFinalValueListener { min, max ->
            Log.d("CRS=>",min.toString()+" : "+max.toString())
        }
        rb_ready.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_ready.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_ready.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_12.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_12.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_12.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_24.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_24.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_24.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_36.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_36.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_36.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        //kind
        rb_oneRoom.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_oneRoom.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_oneRoom.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_twoRoom.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_twoRoom.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_twoRoom.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_threeRoom.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_threeRoom.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_threeRoom.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        rb_fourRoom.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked){
                rb_fourRoom.setTextColor(applicationContext.resources.getColor(R.color.pumpkinOrange))
            }else{
                rb_fourRoom.setTextColor(applicationContext.resources.getColor(R.color.darkGrey))
            }
        }
        btn_setting_init.setOnClickListener {
            rb_ready.isChecked=true
            rb_oneRoom.isChecked=true

            val min=0
            val max=300000

            sb_range.setMinValue(min.toFloat())
            sb_range.setMaxValue(max.toFloat())

            sb_range.setMinStartValue(min.toFloat()).setMaxStartValue(max.toFloat()).apply()

            txt_setting_priceMin.setText("0")
            txt_setting_priceMax.setText("300000")

            dataList.clear()
            dataList.addAll(dataList2)
            dragListRecyclcerViewAdapter.notifyDataSetChanged()
        }
        btn_for_u_setting_finish.setOnClickListener {
            val min: String=txt_setting_priceMin.text.toString()
            val max: String=txt_setting_priceMax.text.toString()

            setForUResult(dataList[0].name,dataList[1].name,dataList[4].name,min.toInt(),max.toInt())
        }

    }

    override fun onStartDrag(holder: DragListRecyclcerViewAdapter.Holder) {
        touchHelper.startDrag(holder)
    }
    fun setForUResult(first: String, second: String, fifth: String, minprice: Int, maxprice:Int){
        val getForUResult: Call<GetForUResultResponse> = networkService.getForUResultResponse(first,second,fifth,minprice,maxprice)
        getForUResult.enqueue(object: Callback<GetForUResultResponse>{
            override fun onResponse(call: Call<GetForUResultResponse>?, response: Response<GetForUResultResponse>?) {
                if(response!!.isSuccessful){
                    val intent: Intent = intent
                    if(rb_ready.isChecked){
                        intent.putExtra("name","예비 자취생 타입")
                    }else if(rb_12.isChecked){
                        intent.putExtra("name","자취 새내기 타입")
                    }else if(rb_24.isChecked){
                        intent.putExtra("name","프로 자취생 타입")
                    }else if(rb_36.isChecked){
                        intent.putExtra("name","자취만렙 타입")
                    }

                    setResult(Activity.RESULT_OK,intent)
                    finish()
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
