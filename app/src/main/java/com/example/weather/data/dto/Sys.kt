package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Sys (
	@SerializedName("type")
	val type : BigDecimal,
	@SerializedName("id")
	val id : BigDecimal,
	@SerializedName("country")
	val country : String,
	@SerializedName("sunrise")
	val sunrise : BigDecimal,
	@SerializedName("sunset")
	val sunset : BigDecimal
)