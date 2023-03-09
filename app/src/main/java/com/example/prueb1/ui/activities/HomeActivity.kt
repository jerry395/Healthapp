package com.example.prueb1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.prueb1.R
import com.example.prueb1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityHomeToolbar.title=""
        setSupportActionBar(binding.activityHomeToolbar)
    }

    override fun onStart() {
        super.onStart()
        binding.activityHomeToolbarImage.setOnClickListener(){

        }

        val navController = findNavController(R.id.nav_host_home_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.specialistFragment,
            R.id.locationFragment,
            R.id.profileFragment
        ))
        binding.activityHomeBottomNavigation.setupWithNavController(navController)
        binding.activityHomeToolbar.setupWithNavController(navController,appBarConfiguration)
    }
}