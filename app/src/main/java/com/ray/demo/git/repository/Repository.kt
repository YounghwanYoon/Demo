package com.ray.demo.git.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ray.demo.git.repository.data.GithubResponse
import com.ray.demo.git.repository.webservice.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    private val URL = "https://api.github.com"
    val TAG ="Repository.class"

    lateinit var gitService:GithubService
    lateinit var mutableGitData:MutableLiveData<List<GithubResponse>>

    fun fetchListOfGitRepo(): Call<List<GithubResponse>> {
        gitService = GithubService.invoke()
        return gitService.getListRepos()

    }

    fun fetchListOfGitData():MutableLiveData<List<GithubResponse>>{
        mutableGitData = MutableLiveData<List<GithubResponse>>()

        GithubService().getListRepos().enqueue( object: Callback<List<GithubResponse>>{
            override fun onFailure(all: Call<List<GithubResponse>>?, t: Throwable?) {
                Log.d(TAG, "onFailure: failed to get data")
                mutableGitData.postValue(null)
            }

            override fun onResponse(call: Call<List<GithubResponse>>?, response: Response<List<GithubResponse>>?) {
                Log.d(TAG, "onResponse: got data")
                mutableGitData.postValue( response!!.body())
            }
        })
        return mutableGitData
    }







}