package com.example.weather.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal


data class Clouds (
	@SerializedName("all")
	val all : BigDecimal
)