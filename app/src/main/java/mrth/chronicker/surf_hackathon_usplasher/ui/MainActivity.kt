package mrth.chronicker.surf_hackathon_usplasher.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
}
