package uz.sardor.myapplication.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.sardor.myapplication.model.Post


class DetailsViewModel(val model: DetailsModel, val id:Int): ViewModel() {
//    private var _post: MutableStateFlow<Post?> = MutableStateFlow(null)
//    val post: StateFlow<Post?> = _post
//
//    fun getPost(){
//
//        viewModelScope.launch {
//
//            _post.value = model.getPost(id)
//        }
//    }

}