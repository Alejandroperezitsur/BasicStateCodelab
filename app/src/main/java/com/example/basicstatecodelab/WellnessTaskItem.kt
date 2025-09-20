// File: WellnessTaskItem.kt
package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable // Importante para que el estado del checkbox persista
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Muestra un item de la lista de tareas de bienestar.
 * Esta versión es SIN ESTADO (stateless) con respecto al Checkbox.
 * El estado 'checked' y su cambio se elevan (hoisted).
 */
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

/**
 * Muestra un item de la lista de tareas de bienestar.
 * Esta versión es CON ESTADO (stateful) para el Checkbox, utilizando rememberSaveable
 * para que el estado persista al salir de la composición (scroll en LazyColumn)
 * y a través de cambios de configuración.
 * Llama a la versión sin estado de WellnessTaskItem.
 */
@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit, // El onClose se pasa para una futura implementación
    modifier: Modifier = Modifier
) {
    // El estado del checkbox se maneja internamente aquí
    // Usamos rememberSaveable para que el estado no se pierda al hacer scroll
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { newValue -> checkedState = newValue },
        onClose = onClose, // Pasamos el callback onClose
        modifier = modifier
    )
}
