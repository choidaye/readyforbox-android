package com.choidaye.readyforbox.DB

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import org.json.JSONArray
import org.json.JSONException

object SearchSharedPreferenceController {
    val SEARCH_WORD="unique"

    fun setSearchWord(ctx: Context,key: String, values: ArrayList<String>){
        val preference: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
        val editor: SharedPreferences.Editor=preference.edit()
        var a: JSONArray= JSONArray()
        for (i in 0..values.size){
            a.put(values.get(i))
        }
        if(values.isEmpty()){
            editor.putString(key,null)
        }else{
            editor.putString(key,a.toString())
        }
        editor.apply()
    }
    /*
    fun getSearchWord(ctx: Context,key: String): ArrayList<String>{
        val preference: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
        var json: String=preference.getString(key,null)
        var urls: ArrayList<String> = ArrayList<String>()
        if(json!=null){
            try{
                var a: JSONArray= JSONArray(json)
                for(i in 0..a.length()){
                    var url: String =a.optString(i)X
                    urls.add(url)
                }
            }catch(e: JSONException){
                e.printStackTrace()
            }
        }
        return urls
    }
    */
}