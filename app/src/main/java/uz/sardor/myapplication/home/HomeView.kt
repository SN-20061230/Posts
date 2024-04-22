package uz.sardor.myapplication.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import uz.sardor.myapplication.item.PostItem

@Composable
fun HomeView(viewModel: HomeViewModel) {

val list = viewModel.posts.collectAsState().value


    LazyColumn {
        if(list != null) {
            items(list.posts.size) {
                PostItem(post = list.posts[it])
            }
        }
    }
}