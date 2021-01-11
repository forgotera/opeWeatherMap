package com.example.weather.data

import android.net.Uri
import com.example.weather.service.WeatherService
import java.net.URL


interface WeatherRepository {

    fun getWeather(service: WeatherService, place: String)
}

class WeatherRepositoryImpl(
) : WeatherRepository {


    companion object {
        private const val SCHEME = "http"
        private const val PATH = "api.openweathermap.org/data/2.5/weather"
        //todo вынести в gradle.properties
        private const val APIKEY = "46f9e573e993ff6f3aa5c67cebe59033"
        private const val LANG = "ru"
        private const val UNITS = "metric"
    }

    private fun createUrl(place: String): URL? {
        val uri = Uri.Builder().scheme(SCHEME).path(PATH)
            .appendQueryParameter("q", place)
            .appendQueryParameter("lang", LANG)
            .appendQueryParameter("units", UNITS)
            .appendQueryParameter("appid", APIKEY)
            .build()
        return URL(uri.toString())
    }

    override fun getWeather(service: WeatherService, place: String) {
        service.execute(createUrl(place))
    }
}