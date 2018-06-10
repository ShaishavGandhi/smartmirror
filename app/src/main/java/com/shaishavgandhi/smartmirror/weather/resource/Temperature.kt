package com.shaishavgandhi.smartmirror.weather.resource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Temperature(val temp: Double,
                       val pressure: Int,
                       val humidity: Int,
                       @Json(name = "temp_min") val min: Double,
                       @Json(name = "temp_max") val max: Double) {
}