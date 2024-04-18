package uz.sardor.myapplication.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.sardor.myapplication.model.Post

@Composable
fun PostItem(post: Post) {
    Card(modifier = Modifier.fillMaxWidth()){

        Column(modifier = Modifier.fillMaxWidth().padding(5.dp)){


           Text( text = post.title, fontSize = 20.sp)

            Text( text = post.body, fontSize = 16.sp)
        }

    }


}

@Composable
fun TagsItem(){
    Button(onClick = {}){

     }
}