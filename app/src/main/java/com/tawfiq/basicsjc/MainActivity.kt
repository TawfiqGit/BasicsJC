package com.tawfiq.basicsjc

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tawfiq.basicsjc.ui.theme.BasicsJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Start call compose function
            BasicsJCTheme {
                // A surface container using the 'background' color from the theme
                val cityList= arrayListOf<String>()
                cityList.add("India")
                cityList.add("France")
                cityList.add("Maroc")

                AppMain(context = LocalContext.current, arrayCity =cityList )
            }
        }
    }
}

@Composable
fun AppMain(context: Context,arrayCity:ArrayList<String>){
    val ex = remember {
        30
    }
    Surface( //Espace
        color = Color.LightGray,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(1F)
        ) {
            for (i in 0 until arrayCity.size){
                CityName(context = context, name = arrayCity[i])
            }
        }
    }
}

@Composable
fun CityName(context: Context,name :String){
    Text(
        text = "Hello $name !",
        textAlign = TextAlign.Center,
        color = Color.Blue
    )

    Row{
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Start")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Start")
        }
        
        FloatingActionButton(onClick = {
            Toast.makeText(context,"Hello Javatpoint",Toast.LENGTH_SHORT).show()
        }) {

        }
    }
}

@Preview(showBackground = true , heightDp = 320)
@Composable
fun DefaultPreview() {
    BasicsJCTheme {
        val list= arrayListOf<String>()
        list.add("India")
        list.add("France")
        list.add("Maroc")
        val context = LocalContext.current

        AppMain(context = context, arrayCity = list)
    }
}