package com.example.weather.domain

import com.example.weather.data.WeatherRepository
import com.example.weather.domain.model.WeatherModel
import com.google.gson.Gson

interface WeatherInteractor{
    fun getWeather(place: String)
}

class WeatherInteractorImpl(
    private val repository:WeatherRepository
):WeatherInteractor {


    override fun getWeather(place: String) {
        val task = repository.getWeather(place)
        task.apply {

        }
    }
}