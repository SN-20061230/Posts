package uz.sardor.myapplication.networking

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.model.PostData

interface APIService {
    @GET("/posts")
    suspend fun getPosts(): PostData

    @GET("/posts/search")
    suspend fun searchByName(@Query("q") name: String): PostData

    @GET("/post/{id}")
    suspend fun getPost(@Path("id") id: Int): Post


}