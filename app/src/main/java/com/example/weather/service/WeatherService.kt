package com.example.weather.service

import android.os.AsyncTask
import com.example.weather.data.dto.WeatherDto
import com.example.weather.domain.mapper.WeatherMapper
import com.example.weather.domain.model.WeatherModel
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


/**
 * класс отвечающий за запросы в сеть
 */
class WeatherService : AsyncTask<URL, Unit, WeatherDto>() {


    companion object {
        const val GET = "GET"
    }


    var response: ((WeatherModel?) -> Unit)? = null
    private val weatherMapper = WeatherMapper()

    override fun doInBackground(vararg params: URL?): WeatherDto? {

        if (params[0] == null) {
            return null
        }
        var connection: HttpURLConnection? = null
        val builder = StringBuilder()
        try {
            connection = params[0]?.openConnection() as HttpURLConnection?
            connection?.requestMethod = GET
            connection?.useCaches = false
            connection?.connectTimeout = 250
            connection?.readTimeout = 250


            //todo по хорошему должна быть обработка кодов
            if (connection?.responseCode in HttpURLConnection.HTTP_OK..HttpURLConnection.HTTP_ACCEPTED) {
                val reader =
                    BufferedReader(InputStreamReader(connection?.inputStream))
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    builder.append(line)
                    builder.append("\n")
                }
                reader.close()
            }
        } catch (cause: Throwable) {
            cause.printStackTrace()
        } finally {
            connection?.disconnect()
        }

        //сериализация в dto
        return Gson().fromJson(builder.toString(), WeatherDto::class.java)
    }

    override fun onPostExecute(result: WeatherDto?) {
        super.onPostExecute(result)
        response?.invoke(weatherMapper.map(result))
    }


}