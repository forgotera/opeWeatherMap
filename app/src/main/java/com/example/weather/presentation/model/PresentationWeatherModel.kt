package com.example.weather.presentation.model

import com.example.weather.domain.WeatherInteractor
import com.example.weather.service.WeatherService

interface PresentationWeatherModel {
    fun getWeather(service: WeatherService, place: String)
}

class PresentationWeatherModelImpl(
    private val interactor: WeatherInteractor
) : PresentationWeatherModel {

    override fun getWeather(service: WeatherService, place: String) {
        interactor.getWeather(service, place)
    }

}