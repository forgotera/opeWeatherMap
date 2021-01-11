package com.example.weather.domain

import com.example.weather.data.WeatherRepository
import com.example.weather.service.WeatherService

interface WeatherInteractor{
    fun getWeather(service: WeatherService, place: String)
}

class WeatherInteractorImpl(
    private val repository:WeatherRepository
):WeatherInteractor {

    override fun getWeather(service: WeatherService,place: String) {
         repository.getWeather(service,place)
    }
}