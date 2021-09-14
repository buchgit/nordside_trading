package com.nordside_trading.api



import androidx.lifecycle.LiveData
import com.nordside_trading.json.Nomenclature
import retrofit2.Call
import retrofit2.http.GET

interface NordsideApi {
    @GET("rest/user/nomenclature/all?email=user@gmail.com")
    fun getAllItems(): Call<List<LiveData<Nomenclature>>>
}