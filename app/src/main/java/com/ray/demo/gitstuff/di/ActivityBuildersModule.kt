package com.ray.demo.gitstuff.di

import com.ray.demo.gitstuff.ui.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

//Telling component that AuthActivity is potential client that I can inject into
//Anything @ContributesAndroidInjector must be abstract class

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
   abstract fun contributeAuthActivity(): AuthActivity


    companion object{
        @Provides
        fun someString():String{
            return "this is a test string"
        }
    }
}