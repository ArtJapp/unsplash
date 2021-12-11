package mrth.chronicker.surf_hackathon_usplasher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.SurfHackathonUsplasherTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfHackathonUsplasherTheme {
                Navigation()
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController,
            startDestination = "splash_screen") {
            composable("splash_screen") {
                Splash(navController = navController)
            }

            // Main Screen
            composable("main_screen") {
                Greeting("kisa")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SurfHackathonUsplasherTheme {
        Greeting("Android")
    }
}