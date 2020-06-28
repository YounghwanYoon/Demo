package com.ray.demo.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ray.demo.R
import com.ray.demo.weather.model.WeatherResponse
import com.ray.demo.weather.model.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {
    private val TAG="Weather Activity.kt"

    private val BASE_URL = "http://api.openweathermap.org/"
    private  lateinit var retrofit:Retrofit
    private lateinit var service:WeatherService
    private lateinit var call: Call<WeatherResponse>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchData()
        setContentView(R.layout.activity_weather)
    }

    init{
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(WeatherService::class.java)
        call = service.getCurrentWeatherData(R.string.lat.toString(),R.string.lon.toString(), R.string.app_name.toString())
    }


    fun fetchData(){
        call.enqueue(object:Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                Log.e(TAG, "failed to fetch data from server ${t?.message}")
            }

            override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                TODO("Not yet implemented")
            }

        })
    }
}