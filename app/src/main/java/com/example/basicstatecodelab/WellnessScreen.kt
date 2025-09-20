// File: WellnessScreen.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList // Importación clave
import androidx.compose.ui.Modifier

// La función getWellnessTasks se mueve aquí y se hace privada para este archivo.
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter() // Asume que StatefulCounter está definido y accesible

        // Crear la lista observable y recordarla
        val list = remember { getWellnessTasks().toMutableStateList() }

        WellnessTasksList(
            list = list, // Pasar la lista mutable
            onCloseTask = { task -> list.remove(task) }, // Lambda para eliminar la tarea de la lista
            modifier = Modifier // Opcional: pasar un modifier si es necesario
        )
    }
}

