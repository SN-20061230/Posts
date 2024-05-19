package uz.sardor.myapplication.screens.home

import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.model.PostData
import uz.sardor.myapplication.networking.APIService

class HomeModel(private val api:APIService) {

    suspend fun getAllPosts():PostData{
        return api.getPosts()
    }
    suspend fun searchPosts(postName:String): PostData{
        return api.searchByName(postName)
    }

    suspend fun getUserPosts(id: Int): PostData {
        return api.getUserPosts(id)
    }
}