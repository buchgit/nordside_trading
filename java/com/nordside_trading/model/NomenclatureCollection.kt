package com.nordside_trading.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class NomenclatureCollection(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var title: String = ""
)