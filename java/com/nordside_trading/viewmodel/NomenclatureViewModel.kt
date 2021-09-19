package com.nordside_trading.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nordside_trading.json.Nomenclature
import com.nordside_trading.repository.NordsideRepository

class NomenclatureViewModel: ViewModel() {

    fun getNomenclatureByCollection(id:String):LiveData<List<Nomenclature>>{
        return NordsideRepository().getNomenclatureByCollection(id)
    }

}