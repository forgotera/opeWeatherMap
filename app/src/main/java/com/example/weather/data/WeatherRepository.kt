package com.example.weather.data

import android.net.Uri
import com.example.weather.data.dto.WeatherDto
import com.example.weather.domain.mapper.WeatherMapper
import com.example.weather.domain.model.WeatherModel
import com.example.weather.service.WeatherService
import com.example.weather.service.WeatherService.AsyncResponse
import java.net.URL


interface WeatherRepository {

    fun getWeather(place: String): WeatherModel?
}

class WeatherRepositoryImpl(
    private val weatherMapper: WeatherMapper
) : WeatherRepository {

    private var data : WeatherModel? = null

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

    override fun getWeather(place: String): WeatherModel? {
        val service = WeatherService()
        service.execute(createUrl(place))

        service.response=(object : AsyncResponse {

            override fun processFinish(output: WeatherDto?) {
                data = weatherMapper.map(output)
            }
        })

        return data
    }
}