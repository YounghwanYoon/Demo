package com.ray.demo.gitstuff

import com.ray.demo.gitstuff.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return null
    }


}