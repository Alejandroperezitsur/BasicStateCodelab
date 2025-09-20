// File: WellnessScreen.kt

package com.example.basicstatecodelab // Asegúrate que este sea tu package name
// En WellnessScreen.kt
import androidx.lifecycle.viewmodel.compose.viewModel // ESTA ES LA IMPORTACIÓN CORRECTA
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel // MUY IMPORTANTE: Para la función viewModel()

// Estas importaciones son necesarias si StatefulCounter y WellnessTasksList están en este paquete
// o si no están en este paquete pero tienen el mismo nombre de paquete raíz.
// Si están en subpaquetes diferentes, necesitarás importaciones más específicas.
// import com.example.basicstatecodelab.StatefulCounter // Si está en este archivo/paquete
// import com.example.basicstatecodelab.WellnessTasksList // Si está en este archivo/paquete
// import com.example.basicstatecodelab.WellnessViewModel // Ya no es necesario importar ViewModel directamente aquí si se usa el delegado viewModel()

// getWellnessTasks() ya no está aquí, se movió a WellnessViewModel.kt

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    // wellnessViewModel se obtiene usando el delegado viewModel().
    // Esto asegura que la instancia correcta del ViewModel se provea
    // y se mantenga durante el ciclo de vida apropiado.
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        // Asumiendo que StatefulCounter está definido en otro archivo
        // (por ejemplo, WaterCounter.kt) dentro del mismo paquete
        // o se importa correctamente.
        StatefulCounter()

        // Asumiendo que WellnessTasksList está definido en WellnessTasksList.kt
        // dentro del mismo paquete o se importa correctamente.
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
            // Puedes añadir un modifier aquí si WellnessTasksList lo acepta y lo necesitas:
            // modifier = Modifier.fillMaxWidth() // Por ejemplo
        )
    }
}
