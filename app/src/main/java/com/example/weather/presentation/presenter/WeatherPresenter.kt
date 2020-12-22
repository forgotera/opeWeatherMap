package com.example.weather.presentation.presenter

import com.example.weather.presentation.model.PresentationWeatherModelImpl
import com.example.weather.presentation.view.ViewInterface


class WeatherPresenter(
    private val view: ViewInterface,
    private val dataModel: PresentationWeatherModelImpl
) {
    fun getWeather(place: String) {
        view.setWeather(dataModel.getWeather(place))
    }
}