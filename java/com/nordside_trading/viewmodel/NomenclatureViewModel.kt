package com.nordside_trading.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nordside_trading.json.NomenclatureCollection
import com.nordside_trading.model.Nomenclature
import com.nordside_trading.repository.NordsideRepository

class NomenclatureViewModel: ViewModel() {
    var  nomenclatureList: LiveData<List<Nomenclature>>? = null

    fun getNomenclatureCollectionByCategoryId(id:String){
        nomenclatureList = NordsideRepository().getNomenclatureByCollection(id)
    }

}