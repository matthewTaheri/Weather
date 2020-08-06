package com.example.weather.api

import com.example.weather.response.WeatherResponse
import com.example.weather.utils.Consts.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q")
        cityName: String,
        @Query("appid")
        appid: String = API_KEY
    ): Response<WeatherResponse>
}