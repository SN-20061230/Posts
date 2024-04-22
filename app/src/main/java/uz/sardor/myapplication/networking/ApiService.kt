package uz.sardor.myapplication.networking

import retrofit2.http.GET
import retrofit2.http.Path
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.model.PostData

interface APIService {
    @GET("/posts")
    suspend fun getPosts(): PostData

//    @GET("products/{id}")
//    suspend fun getPost(@Path("id") id: Int): PostData

}