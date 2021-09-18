package com.nordside_trading

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),FragmentCategory.Callback  {

    private var TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragmentCategory = supportFragmentManager.findFragmentById(R.id.container_fragment_1)
        if (currentFragmentCategory==null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment_1,FragmentCategory.newInstance())
                .commit()
        }
        val currentFragmentCollection = supportFragmentManager.findFragmentById(R.id.container_fragment_2)
        if (currentFragmentCollection == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment_2,FragmentCollection.newInstance(),  "FRAGMENT_COLLECTION")
                .commit()
        }

        val currentFragmentPartner = supportFragmentManager.findFragmentById(R.id.container_fragment_3)
        if (currentFragmentPartner == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment_3,FragmentPartner.newInstance())
                .commit()
        }
    }
    //проброска клика по категории во фрагмент
    override fun onCategorySelected(id: String) {
        Log.v(TAG,id)
        val collectionFragment = supportFragmentManager.findFragmentByTag("FRAGMENT_COLLECTION") as FragmentCollection
        collectionFragment.onCategorySelected(id)
    }

}