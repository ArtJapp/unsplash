package mrth.chronicker.surf_hackathon_usplasher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.SurfHackathonUsplasherTheme

@Composable
fun Splash() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo_bg),
            contentDescription = "Logo background"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_surf_logo),
            contentDescription = "Logo"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo_android),
            contentDescription = "android logo",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SurfHackathonUsplasherTheme(darkTheme = true) {
        Splash()
    }
}