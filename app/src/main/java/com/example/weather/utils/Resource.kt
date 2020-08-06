package com.example.weather.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(massege: String, data: T? = null) : Resource<T>(data, massege)
    class Loading<T> : Resource<T>()
}