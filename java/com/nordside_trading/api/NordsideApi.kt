package com.nordside_trading.api



import com.nordside_trading.json.NomenclatureCollection
import com.nordside_trading.json.PriceTable
import com.nordside_trading.json.Category
import retrofit2.Call
import retrofit2.http.GET

interface NordsideApi {
    @GET("rest/user/nomenclature/all?email=user@gmail.com")
    fun getAllNomenclature(): Call<List<PriceTable>>

    //@GET("rest/user/nomenclature/all?email=user@gmail.com")
    @GET("rest/user/nomenclature/all?email=user@gmail.com")
    fun getNomenclatureList():  Call<List<NomenclatureCollection>>

    @GET("rest/user/category/all")
    fun getAllCategory():  Call<List<Category>>

}