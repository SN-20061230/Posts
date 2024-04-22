package uz.sardor.myapplication.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.sardor.myapplication.model.Post

@Composable
fun PostItem(post: Post) {
//    Card(modifier = Modifier.fillMaxWidth()){
//
//        Column(modifier = Modifier.fillMaxWidth().padding(5.dp)){
//
//
//           Text( text = post.title, fontSize = 20.sp)
//
//            Text( text = post.body, fontSize = 16.sp)
//        }
//
//    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
//        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BasicTextField(
                value = post.title,
                onValueChange = { /* TODO: Handle title change */ },
//                textStyle = MaterialTheme.typography.h6.copy(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            BasicTextField(
                value = post.body,
                onValueChange = { /* TODO: Handle description change */ },
//                textStyle = MaterialTheme.typography.body1.copy(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun TagsItem(){
    Button(onClick = {}){

     }
}