package com.example.weather.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "citiesWeather"
)

data class WeatherResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val cityId: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)