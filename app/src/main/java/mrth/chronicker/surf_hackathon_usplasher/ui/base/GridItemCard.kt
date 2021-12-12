package mrth.chronicker.surf_hackathon_usplasher.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil.compose.rememberImagePainter
import mrth.chronicker.surf_hackathon_usplasher.domain.models.Photo
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.Silver


@Composable
fun GridItemCard(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    var size by remember { mutableStateOf(Size.Zero)}
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clickable(
                onClick = { },
            )
            .onGloballyPositioned { coordinates ->
                size = coordinates.size.toSize()
            },
        color = Silver,
        elevation = 0.dp,
        shape = RectangleShape
    ) {
        val dpHeight = photo.toCardHeightDp(size.width)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dpHeight)
                ,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(photo.urls.small),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
private fun Photo.toCardHeightDp(viewWidth: Float): Dp {
    val pxHeight = viewWidth * height / width
    return LocalDensity.current.run { pxHeight.toDp() }
}