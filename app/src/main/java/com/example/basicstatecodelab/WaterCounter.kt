// File: WaterCounter.kt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row // Importación añadida recientemente
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable // Importación añadida recientemente
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// Se elimina la importación de WellnessTaskItem si no se usa directamente aquí
// import com.example.basicstatecodelab.WellnessTaskItem


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // 'rememberSaveable' guarda el estado a través de cambios de configuración (como rotación)
        // y también a través de la muerte del proceso (si el sistema necesita liberar memoria).
        var count by rememberSaveable { mutableStateOf(0) }

        if (count > 0) {
            // Este estado 'showTask' es local para WaterCounter y se resetea si WaterCounter
            // se elimina de la composición y se vuelve a añadir (a menos que uses rememberSaveable).
            // Si el objetivo es que 'WellnessTaskItem' solo aparezca una vez por sesión de "agua bebida"
            // y no cada vez que count > 0, la lógica necesitaría más refinamiento.
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                // Para usar WellnessTaskItem, asegúrate de que esté definido
                // y que su importación sea correcta.
                // Asumo que WellnessTaskItem está definido como lo corregimos previamente.
                WellnessTaskItem(
                    onClose = { showTask = false }, // Al cerrar, oculta esta instancia de WellnessTaskItem
                    taskName = "Have you taken your 15 minute walk today?"
                    // Puedes añadir un modifier a WellnessTaskItem si es necesario, por ejemplo:
                    // modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Text("You've had $count glasses.")
        }

        // Se usa un Row para los botones
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10 // Ejemplo: Deshabilitar el botón si count llega a 10
            ) {
                Text("Add one")
            }
            // Botón para resetear el contador
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(start = 8.dp) // Espacio a la izquierda del botón de limpiar
            ) {
                Text("Clear water count")
            }
        }
    }
}

// El resto de funciones (StatelessCounter, StatefulCounter, WellnessScreen)
// que estaban en tu archivo original. Las mantengo aquí si son relevantes
// para el contexto completo de tu archivo WaterCounter.kt.
// Si WaterCounter.kt solo debe contener WaterCounter, puedes eliminar estas.

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) { // Añadido Modifier como parámetro
    var waterCount by remember { mutableStateOf(0) }
    // Asumo que AnotherStatelessMethod es un placeholder o una función que tienes definida en otro lugar.
    // Si no existe, esto causará un error.
    // var juiceCount by remember { mutableStateOf(0) } // Ejemplo si tuvieras otro contador

    Column(modifier = modifier) { // Usa el modifier para el Column contenedor
        StatelessCounter(waterCount, { waterCount++ })
        // AnotherStatelessMethod(juiceCount, { juiceCount *= 2 })

        // Si quieres que StatefulCounter también pueda limpiar su propio contador,
        // podrías añadir un botón aquí similar al de WaterCounter o pasar callbacks.
    }
}


// Si WellnessTaskItem está definido en otro archivo (como WellnessTaskItem.kt),
// asegúrate de que se importe correctamente. Si está en el mismo archivo, no hay problema.
// Esta es la definición que corregimos antes para WellnessTaskItem:
@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        androidx.compose.material3.IconButton(onClick = onClose) {
            androidx.compose.material3.Icon(
                androidx.compose.material.icons.Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}


@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    // WaterCounter ya tiene su propio estado interno, por lo que no necesita
    // que StatefulCounter le pase el estado directamente a menos que quieras
    // un control más centralizado.
    // Si el objetivo es mostrar ambos, WaterCounter y StatefulCounter (que a su vez
    // usa StatelessCounter), puedes hacerlo así:
    Column(modifier = modifier) {
        WaterCounter()
        StatefulCounter() // StatefulCounter ahora acepta un modifier
    }
}
