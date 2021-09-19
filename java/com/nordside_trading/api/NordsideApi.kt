package com.nordside_trading.api



import com.nordside_trading.json.NomenclatureCollection
import com.nordside_trading.json.PriceTable
import com.nordside_trading.json.Category
import com.nordside_trading.json.Nomenclature
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NordsideApi {
    @GET("rest/user/nomenclature/all?email=user@gmail.com")
    fun getAllNomenclature(): Call<List<PriceTable>>

    //@GET("rest/user/nomenclature/all?email=user@gmail.com")
    @GET("rest/user/nomenclature/all?email=user@gmail.com")
    fun getNomenclatureList():  Call<List<NomenclatureCollection>>

    @GET("rest/user/category/all")
    fun getAllCategory():  Call<List<Category>>

    @GET("rest/user/collection/category/{id}")
    fun getCollectionByCategory(@Path("id") id: String):  Call<List<NomenclatureCollection>>

    @GET("rest/user/nomenclature/collection/{id}")
    fun getNomenclatureByCollection(@Path("id") id: String):  Call<List<Nomenclature>>

}