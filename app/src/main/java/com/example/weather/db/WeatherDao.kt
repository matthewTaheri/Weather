package com.example.weather.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.weather.response.WeatherResponse

@Dao

interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherResponse: WeatherResponse): Long

    @Query("SELECT * FROM citiesWeather")
    fun getAllCities(): LiveData<List<WeatherResponse>>

    @Delete
    suspend fun deleteCity(weatherResponse: WeatherResponse)
}