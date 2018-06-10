package com.shaishavgandhi.smartmirror.weather

import com.shaishavgandhi.smartmirror.weather.service.WeatherService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class APIManager {

    fun weatherService(): WeatherService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create<WeatherService>(WeatherService::class.java)
    }
}