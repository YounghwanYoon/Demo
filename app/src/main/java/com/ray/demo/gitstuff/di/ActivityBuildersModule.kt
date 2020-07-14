package com.ray.demo.gitstuff.di

import com.ray.demo.gitstuff.di.auth.AuthViewModelsModule
import com.ray.demo.gitstuff.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

//Telling component that AuthActivity is potential client that I can inject into
//Anything @ContributesAndroidInjector must be abstract class

//Only Activity related method will be created

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules =  [
            AuthViewModelsModule::class
        ]
    )
   abstract fun contributeAuthActivity(): AuthActivity


}