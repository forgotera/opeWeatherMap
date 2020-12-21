package com.example.weather.service

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


//todo в порядке исключения asyntask
/**
 * класс отвечающий за запросы в сеть
 */
class WeatherService : AsyncTask<URL, Unit, String>() {


    companion object {
        const val GET = "GET"
    }

    override fun doInBackground(vararg params: URL?): String {

        if (params[0] == null) {
            return ""
        }
        var connection: HttpURLConnection? = null
        val builder = StringBuilder()
        try {
            connection = params[0]?.openConnection() as HttpURLConnection?
            connection?.requestMethod = GET
            connection?.useCaches = false
            connection?.connectTimeout = 250
            connection?.readTimeout = 250


            //todo по хорошему должно быть обработка кодов
            if (HttpURLConnection.HTTP_OK == connection!!.responseCode) {
                val reader =
                    BufferedReader(InputStreamReader(connection.inputStream))
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
        Log.d("answer", builder.toString())
        return builder.toString()
    }


}