package uz.sardor.myapplication.networking

import retrofit2.Call
import retrofit2.http.GET
import uz.sardor.myapplication.model.Post

interface APIService {
    @GET("posts")
    suspend fun getPosts(): List <Post>



}