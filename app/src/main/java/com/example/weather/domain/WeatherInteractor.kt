package com.example.weather.domain

import com.example.weather.data.WeatherRepository

interface WeatherInteractor{
    fun getWeather(place: String)
}

class WeatherInteractorImpl(
    private val repository:WeatherRepository
):WeatherInteractor {


    override fun getWeather(place: String) {
        repository.getWeather(place)
    }
}