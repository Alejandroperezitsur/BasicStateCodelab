package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// import androidx.activity.enableEdgeToEdge // Puedes descomentar si lo usas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme // Corregido: Importar MaterialTheme
import androidx.compose.material3.Surface         // Corregido: Importar Surface
// import androidx.compose.material3.Text // Ya no se usa directamente aquí si solo muestras WaterCounter
// import androidx.compose.runtime.Composable // Ya no se usa directamente aquí si solo muestras WaterCounter
import androidx.compose.ui.Modifier
// import androidx.compose.ui.tooling.preview.Preview // Puedes mantenerlo si tienes otras previews
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

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
                    WaterCounter()
                }
            }
        }
    }
}

// Puedes mantener o eliminar la función Greeting y GreetingPreview si ya no las necesitas
// o si son parte de otro ejercicio.
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicStateCodelabTheme {
        Greeting("Android")
    }
}
*/
