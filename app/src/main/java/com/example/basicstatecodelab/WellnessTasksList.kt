// File: WellnessTasksList.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Asegúrate que sea la importación correcta
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
// La función getWellnessTasks() ya no está aquí, se movió a WellnessScreen.kt
// Y la lista ya no se inicializa con remember aquí.

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>, // La lista ahora se pasa como parámetro
    onCloseTask: (WellnessTask) -> Unit, // Callback para cuando se cierra una tarea
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id } // Usar el id de la tarea como clave
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) } // Llama al callback con la tarea específica
            )
        }
    }
}

