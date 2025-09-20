// File: WellnessScreen.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    // Para que la eliminación de tareas funcione más adelante,
    // la lista necesita ser mutable y recordada aquí.
    val list = remember { getWellnessTasks().toMutableStateList() }

    Column(modifier = modifier) {
        StatefulCounter() // Asume que StatefulCounter está definido y accesible
        WellnessTasksList(
            list = list,
            onCloseTask = { task -> list.remove(task) } // Lógica para eliminar la tarea
        )
    }
}