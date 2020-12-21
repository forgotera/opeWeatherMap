package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Coord (

	@SerializedName("lon")
	val lon : BigDecimal,
	@SerializedName("lat")
	val lat : BigDecimal
)