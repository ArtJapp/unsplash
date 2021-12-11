package mrth.chronicker.surf_hackathon_usplasher.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mrth.chronicker.surf_hackathon_usplasher.R
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.Haiti
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.Haiti32
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.Haiti80
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.LimeGreen
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.SurfHackathonUsplasherTheme
import mrth.chronicker.surf_hackathon_usplasher.ui.theme.WhiteSmoke

@Composable
fun MainContent() {
    val lazyListState = rememberLazyListState()
    var searchQuery: String by remember { mutableStateOf("") }
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        Modifier.fillMaxSize(),
        lazyListState,
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_surf_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(start = 24.dp, top = 8.dp)
                    .width(58.dp)
                    .height(40.dp),
                colorFilter = ColorFilter.tint(Haiti)
            )
        }
        item {
            TextField(
                value = searchQuery,
                onValueChange = { value: String ->
                    if (value.length <= 5) searchQuery = value
                },
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(40.dp)
                    .padding(24.dp),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                label = { SearchFieldLabel() },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.ic_search),
                        "Search icon",
                        tint = Haiti80,
                        modifier = Modifier.padding(vertical = 11.dp, horizontal = 16.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        Icon(
                            painterResource(id = R.drawable.ic_close),
                            "Clear search query icon",
                            tint = LimeGreen,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = WhiteSmoke,
                    focusedIndicatorColor = Color.Transparent, //hide the indicator
                    unfocusedIndicatorColor = Color.Transparent
                ),
                enabled = true,
            )
        }
        item {
            EditorialPictures()
        }
    }
}

@Composable
fun SearchFieldLabel() {
    Text(text = "Search photo ", color = Haiti32, fontSize = 14.sp)
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    SurfHackathonUsplasherTheme {
        MainContent()
    }
}