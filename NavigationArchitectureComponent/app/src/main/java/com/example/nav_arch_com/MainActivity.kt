package com.example.nav_arch_com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //получаем navController
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.navFragment) as NavHostFragment? ?: return
        navController = host.navController

        // включаем боковое меню
        val sideBar = findViewById<NavigationView>(R.id.nav_view)
        sideBar?.setupWithNavController(navController)

        // настраиваем панель инструментов
        /**кнопка "стрелка влево" для встроенных фрагментов*/
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        /**кнопка "кнопка-гамбургер" на главном фрагменте и "стрелка влево" для встроенных фрагментов
         * drawer_layout - параметр*/
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout = drawer_layout) // для бокового меню
        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar) //для верхнего меню
        toolBar.setupWithNavController(navController, appBarConfiguration)

    }

    // включаем верхнее меню (кнопка вверху справа)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_right_menu, menu)
        return true
    }

    // переходим по ссылкам верхнего меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}