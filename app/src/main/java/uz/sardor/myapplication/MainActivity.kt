package uz.sardor.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.sardor.myapplication.home.HomeModel
import uz.sardor.myapplication.home.HomeView
import uz.sardor.myapplication.home.HomeViewModel
import uz.sardor.myapplication.networking.APIClient
import uz.sardor.myapplication.networking.APIService
import uz.sardor.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


            val api = APIClient.getInstance().create(APIService::class.java)
                    val homeModel = HomeModel(api)
                    val homeViewModel = HomeViewModel(homeModel)
                    HomeView(viewModel = homeViewModel)

                }
            }
        }
    }
}
