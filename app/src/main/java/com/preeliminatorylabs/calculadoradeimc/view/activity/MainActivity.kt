package com.preeliminatorylabs.calculadoradeimc.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.preeliminatorylabs.calculadoradeimc.R

class MainActivity : ActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navigateToFragment(FragmentUpcoming.newInstance())
    }
}
