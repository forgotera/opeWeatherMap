package com.example.weather.domain.model

import java.math.BigDecimal

data class WeatherModel(
    val temp : BigDecimal,
    val feels_like : BigDecimal,
    val temp_min : BigDecimal,
    val temp_max : BigDecimal
)