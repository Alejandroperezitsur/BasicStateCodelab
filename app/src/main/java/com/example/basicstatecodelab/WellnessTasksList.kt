// File: WellnessTasksList.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

// Esta función debe estar en este archivo o importada si está en WellnessTask.kt
// data class WellnessTask(val id: Int, val label: String) // Ya definida en WellnessTask.kt

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() },
    // El onCloseTask será necesario cuando implementemos la eliminación
    onCloseTask: (WellnessTask) -> Unit // Añadimos este callback para la futura eliminación
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id } // Es buena práctica añadir una key
        ) { task ->
            // Llamamos a la versión de WellnessTaskItem que maneja su propio estado 'checked'
            // y que acepta un callback onClose
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) } // Pasamos el callback con la tarea específica
            )
        }
    }
}