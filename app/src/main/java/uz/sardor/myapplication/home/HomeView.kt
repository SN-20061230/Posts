package uz.sardor.myapplication.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import uz.sardor.myapplication.AnimatedShimmer
import uz.sardor.myapplication.item.PostItem
import java.lang.reflect.Modifier

@Composable
fun HomeView(viewModel: HomeViewModel) {

    val list = viewModel.posts.collectAsState().value
    var loading by remember { mutableStateOf(true) }
    LaunchedEffect(
        key1 = true,
        block = {
            delay(5000)
            loading = false
        }
    )

    if (loading) {
        LazyColumn(
//                modifier = Modifier.padding(bottom = 110.dp, start = 10.dp, end = 10.dp)
        )
        {
            if (list != null) {
                items(list.posts.size) {
                    AnimatedShimmer()
                }
            }

        }
    } else {

    LazyColumn {

        if (list != null) {
            items(list.posts.size) {
                PostItem(post = list.posts[it])
            }
        }
    }
}
}