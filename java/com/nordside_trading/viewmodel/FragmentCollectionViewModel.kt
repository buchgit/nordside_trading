package com.nordside_trading.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nordside_trading.json.NomenclatureCollection
import com.nordside_trading.repository.NordsideRepository

class FragmentCollectionViewModel:ViewModel() {
    var  nomenclatureList:LiveData<List<NomenclatureCollection>>? = NordsideRepository().getNomenclatureList()
}