package com.example.weather.domain.mapper

import com.example.weather.data.dto.WeatherDto
import com.example.weather.domain.model.WeatherModel

class WeatherMapper {

    fun map(dto: WeatherDto?) =
        dto?.main?.temp?.let {
            WeatherModel(
                temp = it,
                feels_like = dto.main.feels_like,
                temp_min = dto.main.temp_min,
                temp_max = dto.main.temp_min
            )
        }

}