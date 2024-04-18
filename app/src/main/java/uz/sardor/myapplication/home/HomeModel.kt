package uz.sardor.myapplication.home

import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.networking.APIService

class HomeModel(private val api:APIService) {

    suspend fun getAllPosts():List<Post>{
        return api.getPosts()
    }

}