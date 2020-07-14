package com.ray.demo.gitstuff

import com.ray.demo.gitstuff.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication



class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
        //        return  DaggerAppComponent.builder().application(this).build()
    }


}