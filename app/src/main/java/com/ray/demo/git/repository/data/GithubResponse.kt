package com.ray.demo.git.repository.data


import com.google.gson.annotations.SerializedName

data class GithubResponse(
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val `private`: Boolean,
    val owner: Owner
)