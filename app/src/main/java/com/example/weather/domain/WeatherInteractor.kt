package com.example.weather.domain

import com.example.weather.data.WeatherRepository
import com.example.weather.domain.model.WeatherModel

interface WeatherInteractor{
    fun getWeather(place: String):WeatherModel?
}

class WeatherInteractorImpl(
    private val repository:WeatherRepository
):WeatherInteractor {


    override fun getWeather(place: String): WeatherModel? {
        return repository.getWeather(place)
    }
}