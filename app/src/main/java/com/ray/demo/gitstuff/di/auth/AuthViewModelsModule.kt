package com.ray.demo.gitstuff.di.auth

import androidx.lifecycle.ViewModel
import com.ray.demo.gitstuff.di.ViewModelKey
import com.ray.demo.gitstuff.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule{

    @Binds
    @IntoMap //Map to particular key and this is what multi binding is
    @ViewModelKey(AuthViewModel::class) //This dependency map to that key
    abstract fun bindAuthVviewModel(viewModel:AuthViewModel): ViewModel

}