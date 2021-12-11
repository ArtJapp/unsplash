package mrth.chronicker.surf_hackathon_usplasher.ui.views.editorial

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mrth.chronicker.surf_hackathon_usplasher.GridItemCard
import mrth.chronicker.surf_hackathon_usplasher.StaggeredVerticalGrid
import org.koin.androidx.compose.viewModel

/**
 * Main Tab with pictures
 */
@Composable
fun EditorialPictures() {
    val vm by viewModel<EditorialPicturesViewModel>()
    StaggeredVerticalGrid(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {

        val data = vm.widgetStateFlow.value
        Log.d("AAA", "$data")
        if (data is EditorialPicturesState.Loaded) {
            data.items.forEach {
                GridItemCard(it.id)
            }
        }
    }
}