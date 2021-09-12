package com.nordside_trading.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Category(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var description: String = ""
)
