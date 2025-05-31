package com.nj.anifetch.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nj.anifetch.R
import com.nj.anifetch.model.AnimeListData

@Composable
fun Dashboard(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
       TabScreen()
    }
}

@Composable
fun TabScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(stringResource(R.string.text_movie), stringResource(R.string.text_tv))

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = tabIndex
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(modifier = Modifier.background(MaterialTheme.colorScheme.tertiary),
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(bottom = 5.dp),
                        color = if (tabIndex == index) Color.Black else Color.LightGray,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        when (tabs[tabIndex]) {
            stringResource(R.string.text_movie) -> {
                ListScreen(stringResource(R.string.text_movie))
            }

            stringResource(R.string.text_tv) -> {
            }
        }
    }
}

@Composable
fun ListScreen(screen: String = stringResource(R.string.text_tv)) {
    var itemsList = listOf(
        AnimeListData(
            name = "Cowboy Bebop",
            duration = "1 hr 55 min",
            score = "8.38",
            year = "2017",
            imageUrl = "https://cdn.myanimelist.net/images/anime/1439/93480.jpg",
            smallImageUrl = "https://cdn.myanimelist.net/images/anime/1439/93480t.jpg",
            largeImageUrl = "https://cdn.myanimelist.net/images/anime/1439/93480l.jpg",
            genre = "Action",
            noOfEpisode = "100",
            ranked = "214",
            synopsis = "Crime is timeless. By the year 2071, humanity has expanded across the galaxy, filling the surface of other planets with settlements like those on Earth. These new societies are plagued by murder, drug use, and theft, and intergalactic outlaws are hunted by a growing number of tough bounty hunters.\n\nSpike Spiegel and Jet Black pursue criminals throughout space to make a humble living. Beneath his goofy and aloof demeanor, Spike is haunted by the weight of his violent past. Meanwhile, Jet manages his own troubled memories while taking care of Spike and the Bebop, their ship. The duo is joined by the beautiful con artist Faye Valentine, odd child Edward Wong Hau Pepelu Tivrusky IV, and Ein, a bioengineered Welsh corgi.\n\nWhile developing bonds and working to catch a colorful cast of criminals, the Bebop crew's lives are disrupted by a menace from Spike's past. As a rival's maniacal plot continues to unravel, Spike must choose between life with his newfound family or revenge for his old wounds."
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        items(itemsList) { item ->
            ListItemDesign(item)
            {
                //TODO I am planning to integrate the navigation to details screen here
            }
        }
    }
}


@Composable
fun ListItemDesign(animeListData: AnimeListData,onClick:()->Unit) {

    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .fillMaxWidth().clickable {
                onClick()
            }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(animeListData.imageUrl)
                    .build(),
                contentDescription = "Anime Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = animeListData.name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star Icon",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = animeListData.score, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = animeListData.genre,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = animeListData.year,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }

}

