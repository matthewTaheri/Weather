package com.example.weather.repository

import com.example.weather.api.RetrofitInstance
import com.example.weather.db.WeatherDatabase
import com.example.weather.response.WeatherResponse

class WeatherRepository(
    val db: WeatherDatabase
) {
    suspend fun getWeather(cityName: String) =
        RetrofitInstance.api.getWeather(cityName)

    suspend fun insertWeather(weatherResponse: WeatherResponse) =
        db.getWeatherDao().insert(weatherResponse)
}