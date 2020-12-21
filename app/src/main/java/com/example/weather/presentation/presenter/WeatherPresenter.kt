package com.example.weather.presentation.presenter

import com.example.weather.domain.WeatherInteractor
import com.example.weather.presentation.view.ViewInterface


class WeatherPresenter(
    private val view: ViewInterface,
    private val interactor: WeatherInteractor
) {

    fun getWeather(place: String) {
        view.setWeather( interactor.getWeather(place))
    }
}