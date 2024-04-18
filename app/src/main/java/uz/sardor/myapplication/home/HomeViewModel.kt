package uz.sardor.myapplication.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.networking.APIClient
import uz.sardor.myapplication.networking.APIService

class HomeViewModel(val model: HomeModel):ViewModel() {
//    private val apiService = APIClient.api
//    val posts: MutableState<List<Post>> = mutableStateOf(emptyList())


    private var _posts:MutableStateFlow<List<Post>?> = MutableStateFlow(null)
    val posts:StateFlow<List<Post>?> = _posts


    private fun getAllPosts(){
        viewModelScope.launch {
            _posts.value = model.getAllPosts()
        }
    }

    init{
        getAllPosts()
    }

}