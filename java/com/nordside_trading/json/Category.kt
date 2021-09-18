package com.nordside_trading.json

import com.google.gson.annotations.SerializedName

class Category(
    var id:String = "",
    @SerializedName("name") var title: String = "",
    var description: String = ""
)
