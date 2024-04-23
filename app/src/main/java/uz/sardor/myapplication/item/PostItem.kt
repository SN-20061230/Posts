package uz.sardor.myapplication.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.navigation.Screens

@Composable
fun PostItem(post: Post, navController: NavController) {

//    val list = listOf(post.tags)

    val initialText = post.tags.joinToString(separator = ", ") // Join tags with comma separator

    val textFieldValue = remember { mutableStateOf(initialText) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
//            navController.navigate(Screens.DetailsView.route)
            }
        ,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BasicTextField(
                value = post.title,
                onValueChange = { /* TODO: Handle title change */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                enabled = false
            )
            BasicTextField(
                value = post.body,
                onValueChange = { /* TODO: Handle description change */ },
                modifier = Modifier.fillMaxWidth(),
                enabled = false

            )


            Button(
                onClick = {
                    // Handle button click event, e.g., submit the tags
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(text = textFieldValue.value)
            }
        }
    }

}

@Composable
fun TagsItem(){
    Button(onClick = {}){

     }
}