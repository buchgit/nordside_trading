package com.nordside_trading.json

import com.google.gson.annotations.SerializedName

data class NomenclatureCollection(
    var id: String = "",
    @SerializedName("name") var title: String = ""

)