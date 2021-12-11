package mrth.chronicker.surf_hackathon_usplasher

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditorialPictures() {
    StaggeredVerticalGrid(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        (1..100).forEach {
            GridItemCard(it.toString())
        }
    }
}