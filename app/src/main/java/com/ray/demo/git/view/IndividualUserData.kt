package com.ray.demo.git.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.ray.demo.R
import com.ray.demo.git.repository.data.GithubResponse
import com.ray.demo.git.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.individual_user.*

class IndividualUserData :AppCompatActivity(){
    lateinit var vm: MainViewModel
    private var data:GithubResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
       // var data = vm.getSelectedData()
        setContentView(R.layout.individual_user)

        vm.listofRepoMutable?.observe(this, Observer {

            data =  vm.getSelectedData()


            Glide.with(this)
                .load(data?.owner?.avatarUrl)
                .into(user_Image)

            user_id.text = data?.id.toString()
            user_name.text = data?.fullName
            repos_url.text = data?.owner?.reposUrl
        } )

    }

    fun setData(response:GithubResponse){
        data = response
    }
}