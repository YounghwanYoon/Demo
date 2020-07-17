package com.ray.demo.git.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ray.demo.R
import com.ray.demo.git.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_listofgitusers.*

class ListOfGitUsers_Activity: AppCompatActivity() {

    private val TAG ="ListOfGitUsers_Activity"
    lateinit var vm:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofgitusers)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        vm.listofRepoMutable?.observe(this, Observer {listOfData ->
            listOfData?.let{
                Log.d(TAG, "onCreate:${it.get(0).fullName} ")
                test_user.text = it.get(0).fullName
            }


        })

    }
}