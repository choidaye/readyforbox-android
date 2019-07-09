package com.choidaye.readyforbox.UI.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.choidaye.readyforbox.Data.PackageDetail
import com.choidaye.readyforbox.R
import com.choidaye.readyforbox.UI.Adapter.PackageDetailRecyclcerViewAdapter
import kotlinx.android.synthetic.main.activity_package.*
import kotlinx.android.synthetic.main.rv_item_fg_package_list.*
import org.jetbrains.anko.startActivity

class PackageActivity : AppCompatActivity() {
    lateinit var packageDetailRecyclcerViewAdapter :PackageDetailRecyclcerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)

        var packageDetailList : ArrayList<PackageDetail> = ArrayList()
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))
        packageDetailList.add(PackageDetail("http://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=500:500&_v=20180523104428","제품명", 3000))

        packageDetailRecyclcerViewAdapter= PackageDetailRecyclcerViewAdapter(applicationContext!!,packageDetailList)
        rv_item_package_detail_all.adapter=packageDetailRecyclcerViewAdapter
        rv_item_package_detail_all.layoutManager=GridLayoutManager(applicationContext!!,2)
    }


}
