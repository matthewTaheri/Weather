package com.example.weather.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.adapters.WeatherAdapter
import com.example.weather.ui.MainActivity
import com.example.weather.ui.viewmodels.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class WeatherFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewmodel: WeatherViewModel
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewmodel = (activity as MainActivity).viewModel
        view.floatingAddActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_weatherFragment_to_addFragment,
                null
            )
        )
        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        weatherAdapter = WeatherAdapter()
        mainFragmentRecyclerview.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewModelObserving(viewModel: WeatherViewModel) {
        viewModel.weather.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is com.example.weather.utils.Resource.Success -> {
                    response.data?.let { weatherResponse ->

                    }
                }
                is com.example.weather.utils.Resource.Error -> {
                    response.message?.let { message ->
                        Log.e("tag", message)
                    }
                }
            }
        })
    }

}