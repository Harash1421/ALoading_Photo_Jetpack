package com.example.acoiljetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.example.acoiljetpack.ui.theme.ACoilJetpackTheme

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ACoilJetpackTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    CoilImage()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CoilImage(){
    Box(modifier = Modifier
        .width(70.dp)
        .height(70.dp),
    contentAlignment = Alignment.Center) {
        val painter = rememberImagePainter(data = "https://abdharash.com/gallery/343fd8df4c9ce1a6d6bcd40268aaabac-ts1619194021.png",
            builder = {
                placeholder(R.drawable.ic_baseline_image_24)
                crossfade(1000)
                error(R.drawable.ic_baseline_error_24)
                transformations(
                    GrayscaleTransformation(),
                    CircleCropTransformation()
                )
            }
        )
        var painterState = painter.state
        Image(painter = painter, contentDescription = "Image Logo")
        //if (painterState is ImagePainter.State.Loading){
          //  CircularProgressIndicator()
        //}
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ACoilJetpackTheme {
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            CoilImage()
        }
    }
}