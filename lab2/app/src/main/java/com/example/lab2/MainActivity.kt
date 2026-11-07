package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                TemperatureScreen()
            }
        }
    }
}

@Composable
fun TemperatureScreen() {
    var temperature by remember { mutableIntStateOf(22) }

    val statusText = when {
        temperature > 25 -> "Жарко"
        temperature < 20 -> "Прохладно"
        else -> "Комфортная температура"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Температура",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$temperature °C",
            fontSize = 64.sp,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (temperature > 16) {
                        temperature--
                    }
                }
            ) {
                Text(text = "—", fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.width(32.dp))

            Button(
                onClick = {
                    if (temperature < 30) {
                        temperature++
                    }
                }
            ) {
                Text(text = "+", fontSize = 24.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = statusText,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
    }
}