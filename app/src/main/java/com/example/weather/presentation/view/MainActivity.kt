package com.example.weather.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.example.weather.R
import com.example.weather.data.WeatherRepositoryImpl
import com.example.weather.domain.WeatherInteractorImpl
import com.example.weather.presentation.presenter.WeatherPresenter

class MainActivity : AppCompatActivity() {


    private val repository = WeatherRepositoryImpl()
    private val interactor = WeatherInteractorImpl(repository)

    val search by lazy { findViewById<EditText>(R.id.search) }
    val weather by lazy { findViewById<TextView>(R.id.weather) }
    private var presenter: WeatherPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindPresenter()

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

    //инициалзация зависимостей
    private fun bindPresenter() {
        if (presenter == null){
            presenter = WeatherPresenter(this, interactor)
        }
    }
}
