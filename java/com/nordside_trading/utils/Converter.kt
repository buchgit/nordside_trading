package com.nordside_trading.utils

import com.nordside_trading.json.PriceTable
import com.nordside_trading.json.NomenclatureCollection

class Converter {
    fun convertTo(priceTable: PriceTable): NomenclatureCollection {
        val nomenclatureCollection: NomenclatureCollection = NomenclatureCollection()
        nomenclatureCollection.title = priceTable.nomenclature?.title ?: "empty title"
        return nomenclatureCollection
    }
    fun convertListTo(priceTableList:List<PriceTable>?):List<NomenclatureCollection>{
        //val nomenclatureCollectionLiveDataList:MutableLiveData<List<NomenclatureCollection>> = MutableLiveData()
        val nomenclatureCollectionList: MutableList<NomenclatureCollection> = mutableListOf()

        if (priceTableList != null) {
            for (priceTable in priceTableList){
                nomenclatureCollectionList.add(convertTo(priceTable))
            }
        }

        //nomenclatureCollectionLiveDataList.value = nomenclatureCollectionList
        return nomenclatureCollectionList
    }
}