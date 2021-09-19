package com.nordside_trading.json

import com.google.gson.annotations.SerializedName

class Nomenclature(
    @SerializedName("name") var title: String = "",
    var length: Double = 0.00,
    var width: Double = 0.00,
    var UnitSquare: Double = 0.00,
    var reliefHeight: Double = 0.00,
    var countInPackage: Int,
    var color:String
    )