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

/*
{
    "id": 26,
    "node_id": "MDEwOlJlcG9zaXRvcnkyNg==",
    "name": "merb-core",
    "full_name": "wycats/merb-core",
    "private": false,
    "owner": {
      "login": "wycats",
      "id": 4,
      "node_id": "MDQ6VXNlcjQ=",
      "avatar_url": "https://avatars0.githubusercontent.com/u/4?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/wycats",
      "html_url": "https://github.com/wycats",
      "followers_url": "https://api.github.com/users/wycats/followers",
      "following_url": "https://api.github.com/users/wycats/following{/other_user}",
      "gists_url": "https://api.github.com/users/wycats/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/wycats/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/wycats/subscriptions",
      "organizations_url": "https://api.github.com/users/wycats/orgs",
      "repos_url": "https://api.github.com/users/wycats/repos",
      "events_url": "https://api.github.com/users/wycats/events{/privacy}",
      "received_events_url": "https://api.github.com/users/wycats/received_events",
      "type": "User",
      "site_admin": false
    },
 */