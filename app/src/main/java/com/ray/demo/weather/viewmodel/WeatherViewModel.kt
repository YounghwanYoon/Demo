package com.ray.demo.weather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class WeatherViewModel: ViewModel() {

    private var responseLiveData:MutableLiveData<String> = MutableLiveData()
    private var disposbles = CompositeDisposable()



}