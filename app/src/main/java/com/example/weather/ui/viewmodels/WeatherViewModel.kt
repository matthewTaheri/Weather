package com.example.weather.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.repository.WeatherRepository
import com.example.weather.response.WeatherResponse
import com.example.weather.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class WeatherViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    val weather: MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()

    fun getWeather(cityName: String) = viewModelScope.launch(Dispatchers.IO) {
        weather.postValue(Resource.Loading())
        val response = weatherRepository.getWeather(cityName)
        weather.postValue(handleWeatherResponse(response))
    }

    fun insertWeather(weatherResponse: WeatherResponse) = viewModelScope.launch(Dispatchers.IO) {
        val id = weatherRepository.insertWeather(weatherResponse)
    }

    private fun handleWeatherResponse(response: Response<WeatherResponse>):
            Resource<WeatherResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}