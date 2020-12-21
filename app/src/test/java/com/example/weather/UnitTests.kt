package com.example.weather

import com.example.weather.data.dto.*
import com.example.weather.domain.mapper.WeatherMapper
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal


class UnitTests {
    @Test
    fun mapWeatherTest() {
        val dto = WeatherDto(
            coord = Coord(BigDecimal.ZERO, BigDecimal.ZERO),
            weather = listOf<Weather>(),
            base = "",

            main = Main(
                temp = BigDecimal(1),
                feels_like = BigDecimal(2),
                temp_min = BigDecimal(-3),
                temp_max = BigDecimal(4),
                pressure = BigDecimal(5),
                humidity = BigDecimal(6)
            ),
            visibility = BigDecimal.ZERO,
            wind = Wind(BigDecimal.ZERO, BigDecimal.ZERO),
            clouds = Clouds(BigDecimal.ZERO),
            dt = BigDecimal.ZERO,
            sys = Sys(BigDecimal.ZERO, BigDecimal.ZERO, "", BigDecimal.ZERO, BigDecimal.ZERO),
            timezone = BigDecimal.ZERO,
            id = BigDecimal.ZERO,
            name = "",
            cod = BigDecimal.ZERO

        )

        val result = WeatherMapper().map(dto)

        Assert.assertEquals(result?.temp, BigDecimal(1))
        Assert.assertEquals(result?.feels_like,  BigDecimal(2))
        Assert.assertEquals(result?.temp_min,  BigDecimal(-3))
        Assert.assertEquals(result?.temp_max, BigDecimal(4))


    }
}