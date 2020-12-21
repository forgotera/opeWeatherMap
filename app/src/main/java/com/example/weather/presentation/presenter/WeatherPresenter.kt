package com.example.weather.presentation.presenter

import com.example.weather.domain.WeatherInteractor
import com.example.weather.presentation.view.MainActivity


class WeatherPresenter(
    mainActivity: MainActivity,
    private val interactor: WeatherInteractor
) {



    fun getWeather(place: String) {
        interactor.getWeather(place)
    }
}