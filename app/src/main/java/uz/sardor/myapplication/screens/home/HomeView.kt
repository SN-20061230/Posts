package uz.sardor.myapplication.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.sardor.myapplication.AnimatedShimmer
import uz.sardor.myapplication.item.PostItem

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    val list = viewModel.posts.collectAsState().value

//    val items = viewModel.items.observeAsState().value
    var loading by remember { mutableStateOf(true) }
    LaunchedEffect(
        key1 = true,
        block = {
            delay(3000)
            loading = false
        }
    )

    Column(modifier = Modifier.height(50.dp).padding(top = 20.dp, start = 10.dp,end = 10.dp)){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),

            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.searchProduct(searchText.text)
            },
            placeholder = { Text("Search") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),

        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        )

    }

    if (loading) {
        LazyColumn(modifier = Modifier.padding(top = 80.dp))
        {
            if (list != null) {
                items(list.posts.size) {
                    AnimatedShimmer()
                }
            }

        }
    } else {

    LazyColumn(modifier = Modifier.padding(top = 80.dp)) {

        if (list != null) {
            items(list.posts.size) { item->
                PostItem(post = list.posts[item], navController)
            }
        }
    }
}
}