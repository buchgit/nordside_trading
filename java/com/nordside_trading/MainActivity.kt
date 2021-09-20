package com.nordside_trading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nordside_trading.json.Nomenclature

class MainActivity : AppCompatActivity(), FragmentCategory.Callback, FragmentCollection.Callback, FragmentNomenclatureList.CallbackNomenclature  {

    private var TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.container_activity_main_1)
        if (currentFragment==null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_activity_main_1, FragmentCommon.newInstance(), "FRAGMENT_COMMON")
                .addToBackStack("FRAGMENT_COMMON")
                .commit()
        }
    }
    //проброска клика по категории во фрагмент
    override fun onCategorySelected(id: String) {
        //Log.v(TAG,id)
        val fragment = supportFragmentManager.findFragmentByTag("FRAGMENT_COMMON") as FragmentCommon
        fragment.onCategorySelected(id)
    }
    //проброска клика по коллекции во фрагмент
    override fun onCollectionSelected(id: String) {
        //Log.v(TAG, id)
        val fragment = FragmentNomenclatureList.newInstance(id)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_activity_main_1, fragment)
            .addToBackStack("FRAGMENT_NOMENCLATURE_LIST")
            .commit()
    }
    //проброска клика по позиции номенклатуры в списке, открывает карточку номенклатуры на всю страничку
    override fun onNomenclatureSelected(nomenclature: Nomenclature) {
        val fragment = FragmentNomenclatureItem.newInstance(nomenclature)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_activity_main_1, fragment)
            .addToBackStack("FRAGMENT_NOMENCLATURE")
            .commit()
    }

}