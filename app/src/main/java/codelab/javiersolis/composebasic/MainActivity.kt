package codelab.javiersolis.composebasic

import android.os.Bundle
import androidx.compose.material3.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codelab.javiersolis.composebasic.ui.theme.ComposeBasic120924Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasic120924Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    GreetingCard(
                        modifier = Modifier.padding(16.dp)
                    )
                }
                /**
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val paintImage = painterResource(id = R.drawable.androidparty)
    Image(
        painter = paintImage,
        contentDescription = "fondo de cumpleaños",
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )
}

@Composable
fun GreetingCard(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        GreetingImage()
        Greeting(
            name = "Android",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
        content = {
            Text(
                text = "Happy byrthay $name",
                fontSize = 50.sp,
                lineHeight = 60.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "From javier",
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally),
            )
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
    ComposeBasic120924Theme {
        GreetingCard()
    }
}


@Preview(showBackground = true, name="Light Mode")
@Composable
fun GreetingPreview() {
    ComposeBasic120924Theme {
        Greeting("María")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingImagePreview() {
    ComposeBasic120924Theme {
        GreetingImage()
    }
}

