package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Weather (
	@SerializedName("id")
	val id : BigDecimal,
	@SerializedName("main")
	val main : String,
	@SerializedName("description")
	val description : String,
	@SerializedName("icon")
	val icon : String
)