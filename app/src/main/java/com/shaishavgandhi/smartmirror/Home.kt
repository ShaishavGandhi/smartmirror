package com.shaishavgandhi.smartmirror

import android.app.Activity
import android.os.Bundle
import com.shaishavgandhi.smartmirror.weather.APIManager
import com.shaishavgandhi.smartmirror.weather.repository.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Skeleton of an Android Things activity.
 *
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 *
 * <pre>{@code
 * val service = PeripheralManagerService()
 * val mLedGpio = service.openGpio("BCM6")
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
 * mLedGpio.value = true
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 *
 */
class Home : Activity() {

    lateinit var weatherRepository: WeatherRepository

    val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        weatherRepository = WeatherRepository(APIManager().weatherService())

        val disposable = weatherRepository.weather("San Francisco")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mainText.text = "${response.main.temp} F"
            }, { error ->

            })

        disposables.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}
