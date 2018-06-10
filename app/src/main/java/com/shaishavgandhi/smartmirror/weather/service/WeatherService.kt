package com.shaishavgandhi.smartmirror.weather.service

import com.shaishavgandhi.smartmirror.weather.resource.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun weather(@Query("q") city: String,
                @Query("units") unit: String,
                @Query("appid") appId: String): Observable<WeatherResponse>

}