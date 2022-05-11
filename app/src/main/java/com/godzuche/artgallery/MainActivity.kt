package com.godzuche.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godzuche.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ArtGalleryApp()
                }
            }
        }
    }
}

@Composable
fun ArtGalleryApp() {
    var art by remember {
        mutableStateOf(arts[0])
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(art.artResource),
            contentDescription = art.title,
            modifier = Modifier.wrapContentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = art.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = art.artist + " (${art.year})",
                fontSize = 16.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .wrapContentSize(align = Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (arts.indexOf(art) <= 0) {
                        return@Button
                    }
                    art = arts[arts.indexOf(art) - 1]
                }
            ) {
                Text(text = "Previous")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (arts.indexOf(art) >= arts.lastIndex) {
                        return@Button
                    }
                    art = arts[arts.indexOf(art) + 1]
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtGalleryTheme {
        ArtGalleryApp()
    }
}