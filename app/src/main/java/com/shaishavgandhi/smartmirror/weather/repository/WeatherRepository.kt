package com.shaishavgandhi.smartmirror.weather.repository

import com.shaishavgandhi.smartmirror.weather.resource.WeatherResponse
import com.shaishavgandhi.smartmirror.weather.service.WeatherService
import io.reactivex.Observable

class WeatherRepository(private val service: WeatherService) {

    fun weather(city: String): Observable<WeatherResponse> {
        return service.weather(city, "imperial", "377b71700b9269b9de033a45dcaf225d")
    }
}