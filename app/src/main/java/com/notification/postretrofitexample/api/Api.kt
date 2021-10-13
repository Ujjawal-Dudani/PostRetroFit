package com.notification.postretrofitexample.api

import com.notification.postretrofitexample.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//Base Url = https://jsonplaceholder.typicode.com/posts
interface Api {
    @FormUrlEncoded
    @POST("posts")
    fun createUser(
        @Field("password") title:String,
        @Field("school") body:String,
    ):Call<DefaultResponse>
}