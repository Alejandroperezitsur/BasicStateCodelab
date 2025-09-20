// File: WellnessTasksList.kt
package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit, // Nuevo callback para el estado 'checked'
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked, // Pasamos el estado 'checked' de la tarea
                onCheckedChange = { checkedValue -> onCheckedTask(task, checkedValue) }, // Callback para el cambio de 'checked'
                onClose = { onCloseTask(task) }
            )
        }
    }
}