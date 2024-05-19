package uz.sardor.myapplication.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.model.PostData


class DetailsViewModel(val model: DetailsModel, val id:Int): ViewModel() {
    private var _posts:MutableStateFlow<Post?> = MutableStateFlow(null)
    val posts:StateFlow<Post?> = _posts


    init {
        getPost()
    }
    private fun getPost(){

        viewModelScope.launch {

            _posts.value = model.getPost(id)
        }
    }

}