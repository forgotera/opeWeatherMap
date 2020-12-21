package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal


data class WeatherDto(
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("visibility")
    val visibility: BigDecimal,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt")
    val dt: BigDecimal,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: BigDecimal,
    @SerializedName("id")
    val id: BigDecimal,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: BigDecimal
)