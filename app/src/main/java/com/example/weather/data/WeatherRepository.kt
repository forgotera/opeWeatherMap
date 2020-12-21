package com.example.weather.data

import android.net.Uri
import com.example.weather.service.WeatherService
import java.net.URL

interface WeatherRepository{
    fun getWeather(place: String)
}

class WeatherRepositoryImpl:WeatherRepository {

    companion object {
        const val PATH = "api.openweathermap.org/data/2.5/weather"
        //todo вынести в gradle.properties
        const val APIKEY = "46f9e573e993ff6f3aa5c67cebe59033"
    }

    private fun createUrl(place: String): URL? {
        val uri = Uri.Builder().scheme("http").path(PATH).appendQueryParameter("q", place)
            .appendQueryParameter("appid", APIKEY).build()
        return URL(uri.toString())
    }

    override fun getWeather(place: String) {
        val service = WeatherService()
        service.execute(createUrl("dmitrov"))
    }
}