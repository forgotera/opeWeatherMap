package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName

data class Coord (

	@SerializedName("lon") val lon : Double,
	@SerializedName("lat") val lat : Double
)