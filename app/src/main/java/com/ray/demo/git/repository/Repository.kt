package com.ray.demo.git.repository

import com.ray.demo.git.repository.webservice.GithubService
import retrofit2.Retrofit

class Repository {

    val URL = "https://api.github.com"

    lateinit var retrofit:Retrofit
    lateinit var gitService:GithubService

    init{
        retrofit = buildRetrofit()
        gitService = createGitService()
    }

    private fun buildRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(URL)
           // .addConverterFactory(GsonConverterFactory)
            .build()

    }

    private fun createGitService():GithubService{
        return retrofit.create(GithubService::class.java)
    }

    fun fetchListOfGitRepo(){
        //gitService.listRepos().enqueue(

        //)
    }



}