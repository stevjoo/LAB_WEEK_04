package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Mengatur Toolbar sebagai Action Bar utama aplikasi
        setSupportActionBar(findViewById(R.id.toolbar))

        // 2. Menemukan NavController dari NavHostFragment di layout
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // 3. Membuat konfigurasi untuk AppBar (Action Bar)
        // Menentukan destinasi level atas (yang akan menampilkan ikon hamburger)
        // dan menghubungkannya dengan DrawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment, R.id.favoritesFragment
            ), findViewById(R.id.drawer_layout)
        )

        // 4. Menghubungkan Action Bar dengan NavController
        // Ini akan otomatis mengubah judul di Toolbar dan menampilkan ikon hamburger/panah kembali
        setupActionBarWithNavController(navController, appBarConfiguration)

        // 5. Menghubungkan NavigationView dengan NavController
        // Ini akan otomatis menangani klik pada item menu dan menavigasikan ke fragment yang sesuai
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)
    }

    // Fungsi ini dipanggil ketika pengguna menekan tombol "Up" (panah kembali) di Action Bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}