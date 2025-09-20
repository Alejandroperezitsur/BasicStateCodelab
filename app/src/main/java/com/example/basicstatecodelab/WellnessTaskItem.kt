// File: WellnessTaskItem.kt
package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Solo queda la versión sin estado, ya que el estado 'checked'
// ahora se maneja en el ViewModel y se pasa a través de WellnessTask.
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean, // El estado 'checked' viene del WellnessTask
    onCheckedChange: (Boolean) -> Unit, // Callback para notificar el cambio de 'checked'
    onClose: () -> Unit, // Callback para notificar el evento de cierre
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
