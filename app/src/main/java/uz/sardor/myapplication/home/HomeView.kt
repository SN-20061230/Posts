package uz.sardor.myapplication.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun HomeView(viewModel: HomeViewModel) {

val list = viewModel.posts.collectAsState().value

}