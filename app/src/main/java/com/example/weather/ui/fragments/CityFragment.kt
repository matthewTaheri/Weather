package com.example.weather.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weather.R
import com.example.weather.ui.MainActivity
import com.example.weather.ui.viewmodels.WeatherViewModel

class CityFragment : Fragment(R.layout.fragment_city_weather) {
    lateinit var viewmodel: WeatherViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewmodel = (activity as MainActivity).viewModel

    }
}