package com.example.weather.presentation.presenter

import com.example.weather.presentation.model.PresentationWeatherModelImpl
import com.example.weather.presentation.view.ViewInterface
import com.example.weather.service.WeatherService


class WeatherPresenter(
    private val view: ViewInterface,
    private val dataModel: PresentationWeatherModelImpl
) {
    fun getWeather(place: String) {
        val service = WeatherService()
        dataModel.getWeather(service, place)
        service.response = {
            view.setWeather(it)
        }
    }
}