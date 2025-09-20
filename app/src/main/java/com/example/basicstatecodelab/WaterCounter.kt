// File: WaterCounter.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons // Necesario para Icons.Filled.Close
import androidx.compose.material.icons.filled.Close // Necesario para el Icono de cerrar
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable // Importante para la persistencia del estado
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Muestra un contador de vasos de agua con un botón para añadir y otro para limpiar.
 * Esta es una versión más antigua del contador del Codelab y probablemente no se esté usando
 * si WellnessScreen usa StatefulCounter.
 */
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        if (count > 0) {
            Text("You've had $count glasses.")
        } else {
            Text("No water drunk yet.") // Mensaje cuando count es 0
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(start = 8.dp),
                enabled = count > 0 // Habilitar solo si hay algo que limpiar
            ) {
                Text("Clear water count")
            }
        }
    }
}

/**
 * Un contador sin estado (stateless) que muestra la cuenta y un botón para incrementar.
 * El estado (count) y la lógica de incremento (onIncrement) se le pasan como parámetros.
 */
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.") // Corregido: eliminado " (from Stateless)"
        }
        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

/**
 * Un contador con estado (stateful) que utiliza rememberSaveable para mantener su propio estado 'count'.
 * Llama a StatelessCounter para la UI.
 * Este es el que se usa en WellnessScreen según el codelab.
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(
        count = waterCount,
        onIncrement = { waterCount++ },
        modifier = modifier
    )
}
