package com.ray.demo.git.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.demo.git.repository.Repository
import com.ray.demo.git.repository.data.GithubResponse
import com.ray.demo.git.repository.webservice.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel(){
    val TAG = "MainViewModel"

    private lateinit var _listofRepoMutable:MutableLiveData<List<GithubResponse>>
    var listofRepoMutable: LiveData<List<GithubResponse>>? = null
    get(){
        return _listofRepoMutable
    }
    init{
        Log.d(TAG, "Inside View Model: ")
        _listofRepoMutable = Repository.fetchListOfGitData()
    }

/*
    fun getData():LiveData<List<GithubResponse>>{

       Repository.fetchListOfGitRepo().enqueue( object : Callback<List<GithubResponse>> {
           override fun onFailure(
               call: Call<List<GithubResponse>>?,
               t: Throwable?) {
               //
               Log.d(Repository.TAG,
                   "onFailure: requesting gitservice failed ")
           }

           override fun onResponse(
               call: Call<List<GithubResponse>>?,
               response: Response<List<GithubResponse>>?) {
               //
               _listofRepoMutable.value = response!!.body()
               listofRepoMutable = _listofRepoMutable
               Log.d(Repository.TAG,
                   "onResponse: requested gitservice data is sucessfully retrieived")
           }
       })
        return listofRepoMutable
    }
*/


}