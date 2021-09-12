package com.nordside_trading.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Item(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var length: Double = 0.00,
    var width: Double = 0.00,
    var UnitSquare: Double = 0.00,
    var reliefHeight: Double = 0.00,
    var countInPackage: Int
    )