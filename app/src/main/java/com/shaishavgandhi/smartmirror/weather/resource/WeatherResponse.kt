package com.shaishavgandhi.smartmirror.weather.resource

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(val name: String,
                           val id: Long,
                           val wind: Wind,
                           val main: Temperature) {
}