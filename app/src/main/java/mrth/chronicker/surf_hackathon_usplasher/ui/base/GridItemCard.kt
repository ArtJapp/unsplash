package mrth.chronicker.surf_hackathon_usplasher

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.Silver


@Composable
fun GridItemCard(
    id: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clickable(
                onClick = { },
            ),
        color = Silver,
        elevation = 0.dp,
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .height((50..200).random().dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = id,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}