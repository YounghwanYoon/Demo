package com.ray.demo.git.repository.webservice

import com.ray.demo.git.repository.data.GithubResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


//const val API_KEY =""

interface GithubService {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user:String): Call<List<GithubResponse>>

    @GET("/repositories?since=10&per_page=31")
    fun listRepos():Call<List<GithubResponse>>

}

