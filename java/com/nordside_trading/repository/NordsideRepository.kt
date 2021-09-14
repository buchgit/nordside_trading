package com.nordside_trading.repository


import androidx.lifecycle.LiveData
import com.nordside_trading.BuildConfig
import com.nordside_trading.api.NordsideApi
import com.nordside_trading.json.Nomenclature
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NordsideRepository {
    var nordsideApi: NordsideApi
    init {

        var retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        nordsideApi = retrofit.create(NordsideApi::class.java)
    }

    fun getAllNomenclature():List<LiveData<Nomenclature>>{
        val siteRequest: Call<List<LiveData<Nomenclature>>> = nordsideApi.getAllItems()

    }

}