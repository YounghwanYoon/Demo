package com.ray.demo.gitstuff.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.ray.demo.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//None activity related materials will be declared in here

@Module
class AppModule{


    @Module
    companion object{

        @Singleton
        //For Glide
        @Provides
        @JvmStatic
        fun provideRequestOption():RequestOptions{
            return RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)//default in case error

        }
        @Singleton
        @Provides
        @JvmStatic
        fun provideGlideInstance(application:Application, requestOptions:RequestOptions/*this is provide by above provideRequestOption()*/): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }

        //providing local image
        @Singleton
        @JvmStatic
        @Provides
        fun provideAppDrawable (application:Application): Drawable? {
            //return requireNotNull(ResourcesCompat.getDrawable(application.resources, R.drawable.logo, null))!!
            //return requireNotNull(ContextCompat.getDrawable(application, R.drawable.logo))

            /** only png file was readable NOT JPG another shitty problem by android but nothing else.**/
            return AppCompatResources.getDrawable(application, R.drawable.logo)!!
            //ContextCompat.getDrawable(application, R.drawable.logo)
        }
    }
}