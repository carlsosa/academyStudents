package com.student.unicdastudentsapp.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.ActivityMainBinding
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import com.student.unicdastudentsapp.presentation.login.LoginActivity
import com.student.unicdastudentsapp.util.Initialize

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // use it to initialize Firebase collections
     //  Initialize().init()
        if (!UserActiveUseCase.isUserActive()) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            setSupportActionBar(binding.appBarMain.toolbar)

            val drawerLayout: DrawerLayout = binding.drawerLayout
            val navView: NavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_content_main)

            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.nav_perfil, R.id.nav_pensum, R.id.nav_news, R.id.nav_calendar,
                    R.id.nav_subjects, R.id.nav_version
                ), drawerLayout
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val user = UserActiveUseCase.getUser()
        if (user != null) {
            val imgView: ImageView = findViewById(R.id.imageView)
            imgView.setImageResource(0)
            val welcomeMessage: TextView = findViewById(R.id.welcome_user_textview)
            welcomeMessage.text = StringBuilder().append("Bienvenido, ").append(user.name)
                .append(" ").append(user.matricula).toString()
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}