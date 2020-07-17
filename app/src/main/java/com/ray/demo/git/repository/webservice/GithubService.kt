package com.ray.demo.git.repository.webservice

import com.ray.demo.git.repository.data.GithubResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


//If API key is required.
private const val API_KEY =""
private const val URL = "https://api.github.com"

interface GithubService {

    @GET("users/{user}/repos")
    fun getListRepos(@Path("user") user:String): Call<List<GithubResponse>>

    @GET("/repositories?since=10&per_page=31")
    fun getListRepos():Call<List<GithubResponse>>

    companion object{
        operator fun invoke():GithubService{
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }


    /*
        When need to add API key to request, instead specifying each with @Query
        do below.
        Also, need to add addCallAdapterFactory for Coroutine when listRepo() return Deferred (Coroutine) object.
     */
    /*
    companion object{
        operator fun invoke():GithubService{
            val requestInterceptor = Interceptor{ chain->
                    val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("key", API_KEY)
                        .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)

        }

    }

     */

}

