package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import WaterCounter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// import androidx.activity.enableEdgeToEdge // Puedes descomentar si lo usas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
// Si WaterCounter.kt está en el mismo paquete, no necesitas esta importación.
// Si está en un subpaquete o paquete diferente, asegúrate de que la importación sea correcta:
// import com.example.basicstatecodelab.WaterCounter // Descomenta y ajusta si es necesario

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() // Puedes descomentar si lo usas
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llamamos a la función Composable WaterCounter.
                    // Esta ahora es la versión interactiva que definimos en WaterCounter.kt
                    WaterCounter()
                }
            }
        }
    }
}
