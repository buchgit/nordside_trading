package com.nordside_trading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), FragmentCategory.Callback, FragmentCollection.Callback  {

    private var TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragmentCategory = supportFragmentManager.findFragmentById(R.id.container_activity_main_1)
        if (currentFragmentCategory==null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_activity_main_1, FragmentCommon.newInstance(), "FRAGMENT_COMMON")
                .addToBackStack("FRAGMENT_COMMON")
                .commit()
        }
    }
    //проброска клика по категории во фрагмент
    override fun onCategorySelected(id: String) {
        Log.v(TAG,id)
        val fragment = supportFragmentManager.findFragmentByTag("FRAGMENT_COMMON") as FragmentCommon
        fragment.onCategorySelected(id)
    }

    override fun onCollectionSelected(id: String) {
        Log.v(TAG, id)
        val fragment = FragmentNomenclature.newInstance(id)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_activity_main_1, fragment)
            .addToBackStack("FRAGMENT_NOMENCLATURE")
            .commit()
    }

}