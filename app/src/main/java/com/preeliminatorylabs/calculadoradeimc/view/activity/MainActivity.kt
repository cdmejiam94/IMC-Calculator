package com.preeliminatorylabs.calculadoradeimc.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.view.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : ActivityBase(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Calculadora de IMC"

        val drawerToggle: ActionBarDrawerToggle = object  : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolBar,
            (R.string.open),
            (R.string.close)
        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        navigateToFragment(FragmentIMC.newInstance())

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.backlog -> {
                navigateToFragment(FragmentBacklog.newInstance())
            }
            R.id.get_clients -> {
                navigateToFragment(FragmentClientsData.newInstance())
            }
            R.id.post_clients -> {
                navigateToFragment(FragmentAddClients.newInstance())
            }
            R.id.put_clients -> {
                navigateToFragment(FragmentUpdateClients.newInstance())
            }
            R.id.imc_calculator -> {
                navigateToFragment(FragmentIMC.newInstance())
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }
}
