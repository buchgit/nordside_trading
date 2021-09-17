package com.nordside_trading.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nordside_trading.BuildConfig
import com.nordside_trading.api.NordsideApi
import com.nordside_trading.json.Category
import com.nordside_trading.json.NomenclatureCollection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NordsideRepository {

    val TAG = NordsideRepository::class.java.simpleName
    var nordsideApi: NordsideApi

    init {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        nordsideApi = retrofit.create(NordsideApi::class.java)
    }

    fun getNomenclatureList(): LiveData<List<NomenclatureCollection>> {
        val nomenclatureCollectionList: MutableLiveData<List<NomenclatureCollection>> =
            MutableLiveData()
        val siteRequest: Call<List<NomenclatureCollection>> = nordsideApi.getNomenclatureList()
        siteRequest.enqueue(object : Callback<List<NomenclatureCollection>> {
            override fun onResponse(
                call: Call<List<NomenclatureCollection>>,
                response: Response<List<NomenclatureCollection>>
            ) {
                val responseBody: List<NomenclatureCollection>? = response.body()
                Log.v(TAG, "${responseBody?.size.toString()} -> onResponse")
                nomenclatureCollectionList.value = responseBody
            }

            override fun onFailure(call: Call<List<NomenclatureCollection>>, t: Throwable) {
                Log.v(TAG, "${t.stackTrace.toString()} ->  onFailure")
            }

        })
        return nomenclatureCollectionList
    }

    fun getAllCategory():LiveData<List<Category>>{
        val listLiveData:MutableLiveData<List<Category>> = MutableLiveData()
        val siteRequest:Call<List<Category>> = nordsideApi.getAllCategory()
        siteRequest.enqueue(object :Callback<List<Category>>{
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                val responseBody: List<Category>? = response.body()
                Log.v(TAG, "${responseBody?.size.toString()} -> onResponse")
                listLiveData.value = responseBody
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.v(TAG, "${t.stackTrace.toString()} ->  onFailure")
            }
        })
        return listLiveData
    }

}
