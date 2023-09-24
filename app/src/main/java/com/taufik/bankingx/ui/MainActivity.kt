package com.taufik.bankingx.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var navController: NavController? = null
    private val navControllerDestination = NavController.OnDestinationChangedListener { _, destination, _ ->
        when (destination.id) {
            R.id.splashScreenFragment -> {
                showBottomNavigation(false)
                showFabCardViewHome(false)
            }
            else -> {
                showBottomNavigation(true)
                showFabCardViewHome(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNavHost()
        setUpNavigationDestination()
    }

    private fun setNavHost() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController?.let { binding.navBottom.setupWithNavController(it) }
    }

    private fun setUpNavigationDestination() {
        navController?.addOnDestinationChangedListener(navControllerDestination)
    }

    private fun showFabCardViewHome(isShow: Boolean) {
        binding.apply {
            fabHome.isVisible = isShow
            cardHome.isVisible = isShow
        }
    }

    private fun showBottomNavigation(isShow: Boolean) {
        binding.navBottom.isVisible = isShow
    }

    override fun onDestroy() {
        navController?.removeOnDestinationChangedListener(navControllerDestination)
        navController = null
        super.onDestroy()
    }
}