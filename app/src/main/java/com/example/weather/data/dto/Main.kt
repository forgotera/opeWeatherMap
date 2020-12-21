package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Main (

	@SerializedName("temp")
	val temp : BigDecimal,
	@SerializedName("feels_like")
	val feels_like : BigDecimal,
	@SerializedName("temp_min")
	val temp_min : BigDecimal,
	@SerializedName("temp_max")
	val temp_max : BigDecimal,
	@SerializedName("pressure")
	val pressure : BigDecimal,
	@SerializedName("humidity")
	val humidity : BigDecimal
)