package com.hassan.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hassan.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var count by remember{
        mutableStateOf(1)
    }
    var gallery = when (count) {
        1 -> {
            ArtSpaceGallery(
                image = R.drawable.mountain,
                title = R.string.mountain,
                artist = R.string.mountain_artist,
                year = R.string.mountain_year
            )
        }
        else -> println("Error")
    }
}

@Composable
fun ArtSpaceGallery(image: Int, title: Int, artist: Int, year: Int){
    Column(modifier = Modifier.padding(15.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier.heightIn(500.dp, 530.dp).wrapContentHeight(Alignment.CenterVertically)
        ) {
            Image(painter = painterResource(image), contentDescription = stringResource(title), modifier = Modifier.border(3.dp, Color.Black, RectangleShape).padding(16.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(15.dp)
        ) {
            Row {
                Surface(modifier = Modifier.heightIn(80.dp, 300.dp).widthIn(300.dp, 380.dp), shape = RectangleShape,) {
                    Box {
                        Text(text = stringResource(title), fontSize = 30.sp, fontStyle = FontStyle.Italic
                        )
                    }
                    Box(modifier = Modifier.padding(top = 50.dp),) {
                        Text(text = stringResource(artist) +" ("+ stringResource(year)+")", fontSize = 18.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}