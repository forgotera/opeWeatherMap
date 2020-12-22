package com.example.weather.presentation.model

import com.example.weather.domain.WeatherInteractor
import com.example.weather.domain.model.WeatherModel

interface PresentationWeatherModel {
    fun getWeather(place: String): WeatherModel?
}

class PresentationWeatherModelImpl(
    private val interactor: WeatherInteractor
) : PresentationWeatherModel {

    override fun getWeather(place: String): WeatherModel? =
        interactor.getWeather(place)

}