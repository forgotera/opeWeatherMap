package com.example.weather

import android.net.Uri
import com.example.weather.service.WeatherService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.URL

class ServiceTest {
    private lateinit var networkServie: WeatherService

    @Before
    fun setup() {
        networkServie = WeatherService()
    }

    private fun createUrl(place: String): URL? {
        val uri = Uri.Builder().scheme("http").path("api.openweathermap.org/data/2.5/weather")
            .appendQueryParameter("q", place)
            .appendQueryParameter("lang", "ru").appendQueryParameter("units", "metric")
            .appendQueryParameter("appid", "46f9e573e993ff6f3aa5c67cebe59033").build()
        return URL(uri.toString())
    }

    @Test
    fun serviceTest() {

        val service = WeatherService()
        service.execute(createUrl("tokio"))
        Assert.assertNotNull(service.get())
    }


}
