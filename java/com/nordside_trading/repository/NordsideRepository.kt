package com.nordside_trading.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nordside_trading.BuildConfig
import com.nordside_trading.api.NordsideApi
import com.nordside_trading.json.PriceTable
import com.nordside_trading.json.PriceTableArray
import com.nordside_trading.model.Nomenclature
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

    fun getAllNomenclature(): LiveData<List<PriceTable>>? {

        val responseLiveData: MutableLiveData<List<PriceTable>> = MutableLiveData()

        val siteRequest: Call<PriceTableArray> = nordsideApi.getAllItems()
        siteRequest.enqueue(object : Callback<PriceTableArray> {
            override fun onResponse(
                call: Call<PriceTableArray>,
                response: Response<PriceTableArray>
            ) {
                val responseBody: PriceTableArray? = response.body()
                val listOfPriceLines: List<PriceTable> =
                    responseBody?.listOfPriceLines ?: mutableListOf()
                //listOfPriceLines = listOfPriceLines.filterNot { it.imageUri..... }
                responseLiveData.value = listOfPriceLines

            }

            override fun onFailure(call: Call<PriceTableArray>, t: Throwable) {
                Log.e(TAG, t.stackTrace.toString())
            }

        })
        return responseLiveData
    }

}
