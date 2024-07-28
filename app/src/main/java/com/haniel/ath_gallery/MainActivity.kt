package com.haniel.ath_gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haniel.ath_gallery.model.Art
import com.haniel.ath_gallery.repository.Arts
import com.haniel.ath_gallery.ui.theme.AthGalleryTheme

class MainActivity : ComponentActivity() {

    private val artsRepository = Arts();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AthGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryPreview()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GalleryPreview() {
        val modifier = Modifier
        var indexPhoto by remember { mutableStateOf(0) } // Estado para armazenar o índice da foto
        val art by remember { derivedStateOf { artsRepository.getArt(indexPhoto) } } // Estado derivado para obter a arte atual
        AthGalleryTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                CardPhoto(art, modifier)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        indexPhoto--;
                    }) {
                        Text(text = "Previous")
                    }
                    Button(onClick = {
                        indexPhoto++;
                    }) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }

    @Composable
    fun CardPhoto(art: Art, modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier
                //.border(2.dp, Color.DarkGray)
                .fillMaxWidth()
                .padding(8.dp)
                .shadow(8.dp, shape = MaterialTheme.shapes.extraLarge),
            color = Color.White,
            tonalElevation = 15.dp
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(art.imageID),
                    contentDescription = "${art.title}, autor:${art.author}, ano ${art.year}",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(10.dp)
                )

                Text(
                    text = art.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "${art.author} (${art.year})",
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(8.dp)

                )
            }
        }
    }
}

