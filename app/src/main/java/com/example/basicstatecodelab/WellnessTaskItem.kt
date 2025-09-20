package com.example.basicstatecodelab // Asegúrate que este sea tu package name

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String, // El nombre de la tarea es un parámetro requerido
    onClose: () -> Unit, // Callback para cuando se presiona el botón de cerrar
    modifier: Modifier = Modifier // Modifier opcional para personalizar desde fuera
) {
    Row(
        modifier = modifier, // Usamos el modifier pasado como parámetro
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        IconButton(onClick = onClose) { // El onClick ahora usa el callback onClose
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

