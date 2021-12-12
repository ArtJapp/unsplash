package mrth.chronicker.surf_hackathon_usplasher.ui.views.editorial

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mrth.chronicker.surf_hackathon_usplasher.ui.base.GridItemCard
import mrth.chronicker.surf_hackathon_usplasher.StaggeredVerticalGrid
import org.koin.androidx.compose.viewModel

/**
 * Main Tab with pictures
 */
@Composable
fun EditorialPictures() {
    val vm by viewModel<EditorialPicturesViewModel>()
    val state = vm.widgetStateFlow.collectAsState().value
    StaggeredVerticalGrid(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        if (state is EditorialPicturesState.Loaded) {
            state.items.forEach {
                GridItemCard(it)
            }
        }
    }
}