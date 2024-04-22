package uz.sardor.myapplication.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.screens.home.HomeViewModel

@Composable
fun DetailsView(viewModel: DetailsViewModel, id:Int,navController: NavController) {
//    val list = viewModel.post.collectAsState().value

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(15.dp),
////        shape = RoundedCornerShape(8.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            BasicTextField(
//                value = viewModel.id.toString(),
//                onValueChange = { /* TODO: Handle title change */ },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 8.dp)
//            )
//            BasicTextField(
//                value = post.body,
//                onValueChange = { /* TODO: Handle description change */ },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//    }
}