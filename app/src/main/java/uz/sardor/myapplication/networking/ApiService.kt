package uz.sardor.myapplication.networking

import retrofit2.http.GET
import uz.sardor.myapplication.model.PostData

interface APIService {
    @GET("/posts")
    suspend fun getPosts(): PostData



}