package mrth.chronicker.surf_hackathon_usplasher.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mrth.chronicker.surf_hackathon_usplasher.GridItemCard
import mrth.chronicker.surf_hackathon_usplasher.StaggeredVerticalGrid

/**
 * Main Tab with pictures
 */
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