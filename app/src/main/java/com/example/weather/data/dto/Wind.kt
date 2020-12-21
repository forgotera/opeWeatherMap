package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Wind (
	@SerializedName("speed")
	val speed : BigDecimal,
	@SerializedName("deg")
	val deg : BigDecimal
)