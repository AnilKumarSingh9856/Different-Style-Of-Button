package com.example.differentstyleofbutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.differentstyleofbutton.ui.theme.DifferentStyleOfButtonTheme
import com.example.differentstyleofbutton.ui.theme.color1
import com.example.differentstyleofbutton.ui.theme.color2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DifferentStyleOfButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context1 = LocalContext.current.applicationContext
                   Column(
                       modifier = Modifier.fillMaxSize(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Button(
                           onClick = {
                               Toast.makeText(context1,"Normal Button is Clicked",Toast.LENGTH_SHORT).show()
                           }
                       ) {
                           Text(text = "Confirm")
                       }
                       ElevatedButton(
                           onClick = {
                               Toast.makeText(context1,"ElevatedButton is Clicked",Toast.LENGTH_SHORT).show()
                           }
                       ) {
                           Icon(
                               imageVector = Icons.Outlined.Add, 
                               contentDescription = "Add to Cart",
                               modifier = Modifier.size(18.dp)
                           )
                           Spacer(modifier = Modifier.width(8.dp))
                           Text(text = "Add to Cart")
                       }
                       FilledTonalButton(
                           onClick = {
                               Toast.makeText(context1,"FilledTonalButton is Clicked",Toast.LENGTH_SHORT).show()
                           }
                       ) {
                           Text(text = "open in browser")
                       }
                       OutlinedButton(
                           onClick = {
                               Toast.makeText(context1,"OutlinedButton is Clicked",Toast.LENGTH_SHORT).show()
                           }
                       ) {
                           Text(text = "Back")
                       }
                       TextButton(
                           onClick = {
                               Toast.makeText(context1,"TextButton is Clicked",Toast.LENGTH_SHORT).show()
                           }
                       ) {
                           Text(text = "Learn more")
                       }
                       GradientButton(
                           text = "GradientButton",
                           textColor = Color.White,
                           gradient = Brush.horizontalGradient(
                               colors = listOf(
                                   color1,
                                   color2
                               )
                           )
                       ){}
                       CustomizeButton()

                   }
                }
            }
        }
    }
}
@Composable
fun CustomizeButton(){
    val context = LocalContext.current.applicationContext
    Button(
        onClick = { Toast.makeText(context,"Customize Button is Clicked",Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(size = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green,
            contentColor = Color.Red
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 20.dp
        ),
        modifier = Modifier
            .width(width = 200.dp)
            .height(height = 50.dp)

    ) {
        Text(text = "Clicked Me")

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview1(){
    DifferentStyleOfButtonTheme{
         CustomizeButton()
    }
}
