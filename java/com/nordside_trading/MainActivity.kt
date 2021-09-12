package com.nordside_trading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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
                .add(R.id.container_fragment_2,FragmentCollection.newInstance())
                .commit()
        }

    }
}