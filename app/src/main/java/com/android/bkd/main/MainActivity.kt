package com.android.bkd.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.bkd.R
import com.android.bkd.databinding.ActivityMainBinding
import com.android.bkd.view_model.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModel<MainViewModel>()
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var isLanguageSelected = false
    private var isPickUpLocation: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        configureNavController()

        supportActionBar?.hide()
        showBottomBar()

    }



    private fun configureNavController() {
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration.Builder().build()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun showBottomBar() {
        mBinding.bottomNavigation.setupWithNavController(
            Navigation.findNavController(
                this,
                R.id.nav_host_fragment
            )
        )
        mBinding.bottomNavigation.setOnItemSelectedListener() {
            NavigationUI.onNavDestinationSelected(
                it,
                Navigation.findNavController(this, R.id.nav_host_fragment)
            )
            return@setOnItemSelectedListener true
        }
        mBinding.bottomNavigation.setOnItemReselectedListener() {
        }
    }

}