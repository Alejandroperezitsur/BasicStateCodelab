// File: build.gradle.kts (Project level)

// Declara los plugins comunes a todos los módulos del proyecto
plugins {
    // Aplica el plugin de aplicación de Android (necesario para construir apps)
    id("com.android.application") version "8.13.0" apply false // VERSIÓN AJUSTADA
    // Aplica el plugin de Kotlin para Android
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false // VERSIÓN AJUSTADA
}