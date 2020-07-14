package com.ray.demo.gitstuff.di

import android.app.Application
import com.ray.demo.gitstuff.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =  [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent: AndroidInjector<BaseApplication>{

    @Component.Builder//Overriding build()
    interface Builder{

        //Use when to bind a object/instance to component
        //in this case, it binds application to component
        //LifeCycle of application this component  binds(this:BaseApplication)
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }



}