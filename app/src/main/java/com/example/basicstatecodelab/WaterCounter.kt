// File: WaterCounter.kt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    // 'remember' se usa para mantener el estado a través de las recomposiciones.
    // 'mutableStateOf' crea un estado observable que, cuando cambia,
    // activa una recomposición de los Composables que lo leen.
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "You've had $count glasses."
            // No es necesario un padding aquí si el Column ya lo tiene
        )
        Button(
            onClick = { count++ }, // Incrementa el contador cuando se presiona el botón
            modifier = Modifier.padding(top = 8.dp) // Añade un poco de espacio encima del botón
        ) {
            Text("Add one")
        }
    }
}
