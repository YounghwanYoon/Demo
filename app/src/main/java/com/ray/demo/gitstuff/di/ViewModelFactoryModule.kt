package com.ray.demo.gitstuff.di

import androidx.lifecycle.ViewModelProvider
import com.ray.demo.gitstuff.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

//Responsible for generating dependency injection for viewmodel factory class
@Module
abstract class ViewModelFactoryModule{

    //Two are same but abstract is more efficient to create and provide dependencies.
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
/*
    @Module
    companion object{
        @JvmStatic
        @Provides
        fun bindFactory(factory:ViewModelProviderFactory):ViewModelProvider.Factory{
            return factory
        }
    }
*/


}
