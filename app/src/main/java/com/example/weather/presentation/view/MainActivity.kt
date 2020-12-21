package com.example.weather.presentation.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.example.weather.R
import com.example.weather.data.WeatherRepositoryImpl
import com.example.weather.domain.WeatherInteractorImpl
import com.example.weather.domain.mapper.WeatherMapper
import com.example.weather.domain.model.WeatherModel
import com.example.weather.presentation.presenter.WeatherPresenter

interface ViewInterface {
    /**
     * выставить полученные данные во view
     */
    fun setWeather(weather: WeatherModel?)
}

class MainActivity : AppCompatActivity(), ViewInterface {

    //ключи для сохранения состояния
    companion object {
        const val MAX_TEMPERATURE = "MAX_TEMPERATURE"
        const val MIN_TEMPERATURE = "MIN_TEMPERATURE"
        const val TEMPERATURE = "TEMPERATURE"
        const val FEELS_LIKE_TEMPERATURE = "FEELS_LIKE_TEMPERATURE"
    }

    //зависимости
    private val weatherMapper = WeatherMapper()
    private val repository = WeatherRepositoryImpl(weatherMapper)
    private val interactor = WeatherInteractorImpl(repository)

    private val search: EditText by lazy { findViewById<EditText>(R.id.getcity_edit_text_view) }
    private val mainTemperature: TextView by lazy { findViewById<TextView>(R.id.temperature_text_view) }
    private val maxTemperature: TextView by lazy { findViewById<TextView>(R.id.max_temp) }
    private val minTemperature: TextView by lazy { findViewById<TextView>(R.id.min_temp) }
    private val feelsLikeTemperature: TextView by lazy { findViewById<TextView>(R.id.feels_like) }

    private var presenter: WeatherPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindPresenter()

        search.hint = "Введите город"
        mainTemperature.text = "Тут будет погода"

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                presenter?.getWeather(s.toString())
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }
        })

    }

    private fun bindPresenter() {
        if (presenter == null) {
            presenter = WeatherPresenter(this, interactor)
        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mainTemperature.text = savedInstanceState.getCharSequence(TEMPERATURE)
        maxTemperature.text = savedInstanceState.getCharSequence(MAX_TEMPERATURE)
        minTemperature.text = savedInstanceState.getCharSequence(MIN_TEMPERATURE)
        feelsLikeTemperature.text = savedInstanceState.getCharSequence(FEELS_LIKE_TEMPERATURE)
    }

    //смена ориентации выкл, но так же есть кейс со сменой локали
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putCharSequence(MAX_TEMPERATURE, maxTemperature.text)
        outState.putCharSequence(MIN_TEMPERATURE, minTemperature.text)
        outState.putCharSequence(TEMPERATURE, mainTemperature.text)
        outState.putCharSequence(FEELS_LIKE_TEMPERATURE, feelsLikeTemperature.text)
    }

    @SuppressLint("SetTextI18n")
    override fun setWeather(weather: WeatherModel?) {
        if (weather == null) {
            mainTemperature.text = "Город не найден"
        } else {
            mainTemperature.text = weather.temp.toString() + " C"
            maxTemperature.text = "Максимум " + weather.temp_max.toString() + " C"
            minTemperature.text = "Минимум " + weather.temp_min.toString() + " C"
            feelsLikeTemperature.text = "Ощущается как " + weather.feels_like.toString() + " C"
        }

    }
}
