package com.example.weather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.db.WeatherDatabase
import com.example.weather.repository.WeatherRepository
import com.example.weather.ui.viewmodels.WeatherViewModel
import com.example.weather.ui.viewmodels.WeatherViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = WeatherRepository(WeatherDatabase(this))
        val viewModelProviderFactory = WeatherViewModelProviderFactory(repository)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(WeatherViewModel::class.java)
    }
}
