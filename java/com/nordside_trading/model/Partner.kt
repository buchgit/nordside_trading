package com.nordside_trading.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Partner(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = ""
)
