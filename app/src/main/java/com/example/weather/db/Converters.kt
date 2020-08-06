package com.example.weather.db

import androidx.room.TypeConverter
import com.example.weather.response.*

class Converters {

    @TypeConverter
    fun fromClouds(clouds: Clouds): Int {
        return clouds.all
    }

    @TypeConverter
    fun toClouds(all: Int): Clouds {
        return Clouds(all)
    }

    @TypeConverter
    fun fromCoord(coord: Coord): Pair<Double, Double> {
        return coord.lat to coord.lon
    }

    @TypeConverter
    fun toCoord(lat: Double, lon: Double): Coord {
        return Coord(lat, lon)
    }

    @TypeConverter
    fun fromMain(main: Main): Pair<Double, Double> {
        return main.temp_max to main.temp_min
    }

    @TypeConverter
    fun fromMainTem(main: Main): Double {
        return main.temp
    }

    @TypeConverter
    fun toMain(min: Double, max: Double, temp: Double): Main {
        return Main(temp, max, min)
    }

    @TypeConverter
    fun fromWind(wind: Wind): Double {
        return wind.speed
    }

    @TypeConverter
    fun toWind(speed: Double): Wind {
        return Wind(speed)
    }

    @TypeConverter
    fun fromSys(sys: Sys): Pair<Int, Int> {
        return sys.sunrise to sys.sunset
    }

    @TypeConverter
    fun toSys(rise: Int, set: Int): Sys {
        return Sys(rise, set)
    }

    @TypeConverter
    fun fromWeather(weather: Weather): Pair<String, String> {
        return weather.description to weather.icon
    }

    @TypeConverter
    fun fromWeatherInt(weather: Weather): Int {
        return weather.id
    }

    @TypeConverter
    fun toWeather(desc: String, icon: String, id: Int): Weather {
        return Weather(desc, icon, id)
    }
}