package uz.sardor.myapplication.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.sardor.myapplication.AnimatedShimmer
import uz.sardor.myapplication.item.PostItem

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    var state by remember { mutableStateOf("Home") }
    val list = viewModel.posts.collectAsState().value
    var user_id by remember { mutableStateOf("") }
    val user_carts = viewModel.user_carts.collectAsState().value

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "User Post",
            selectedIcon = Icons.Filled.Edit,
            unselectedIcon = Icons.Outlined.Edit,
        ),
    )
//    val items = viewModel.items.observeAsState().value
    var loading by remember { mutableStateOf(true) }
    LaunchedEffect(
        key1 = true,
        block = {
            delay(3000)
            loading = false
        }
    )

    Scaffold(bottomBar = {
        NavigationBar(containerColor = Color.White) {
            items.forEachIndexed { _, item ->
                NavigationBarItem(selected = state == item.title, onClick = {
                    state = item.title
                }, label = {
                    Text(text = item.title, color = Color.Black)
                }, icon = {
                    Icon(
                        imageVector = if (state == item.title) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = Color.Black,
                    )
                }, colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Gray))
            }
        }
    }) { padding ->
        when (state) {
            "Home" -> {
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

            "User Post" -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(7.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = user_id,
                        onValueChange = {
                            user_id = it
                            if (user_id != "") viewModel.getUserPosts(user_id.toInt())
                        })
                    LazyColumn {
//                        if (list != null && user_carts != null) {
//
//                            items(user_carts.posts.size) { item ->
//                                PostItem(post = list.posts[item], navController)
//
//                            }
//                        }
                    }
                }
            }
        }
    }



}