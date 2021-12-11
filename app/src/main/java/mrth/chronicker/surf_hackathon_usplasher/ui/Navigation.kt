package mrth.chronicker.surf_hackathon_usplasher.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mrth.chronicker.surf_hackathon_usplasher.ui.views.MainContent
import mrth.chronicker.surf_hackathon_usplasher.ui.views.Splash

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
            MainContent()
        }
    }
}