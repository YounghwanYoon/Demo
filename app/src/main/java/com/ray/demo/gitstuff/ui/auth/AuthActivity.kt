package com.ray.demo.gitstuff.ui.auth

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.ray.demo.R
import com.ray.demo.gitstuff.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity: DaggerAppCompatActivity() {
    val TAG = "AuthActivity"
    @Inject
    lateinit var providerFactory:ViewModelProviderFactory

    lateinit var viewModel:AuthViewModel

    @set:Inject internal var logo: Drawable? = null
    @Inject lateinit var requestManager:RequestManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()
    }
    init{
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    private fun setLogo(){
        requestManager.load(logo)
          .into(login_logo)

    }

    object ResourceUtils{
        fun getDrwawable(context: Context, drawable:Int):Drawable{
            return ResourcesCompat.getDrawable(context.getResources(), drawable, null)!!
        }
    }
}