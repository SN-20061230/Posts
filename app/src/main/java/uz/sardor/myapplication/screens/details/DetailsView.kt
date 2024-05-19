package uz.sardor.myapplication.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.sardor.myapplication.model.Post
import uz.sardor.myapplication.screens.home.HomeViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun DetailsView(viewModel: DetailsViewModel) {
    val item by viewModel.posts.collectAsState()

        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {



            if (item != null) {
                Column (modifier = Modifier.fillMaxWidth().padding(5.dp),){

                    Text(item!!.title, fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(item!!.body, fontSize = 18.sp,modifier = Modifier.fillMaxWidth(),)

                }
            }




        }

}