// File: app/build.gradle.kts (Module level)

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.basicstatecodelab" // Cambia si tu namespace es diferente
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.basicstatecodelab" // Cambia si tu ID es diferente
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        // Asegúrate de que esta versión sea compatible con tu versión de Kotlin.
        // Revisa: https://developer.android.com/jetpack/androidx/releases/compose-kotlin
        kotlinCompilerExtensionVersion = "1.5.1" // VERSIÓN AJUSTADA
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.10.1") // VERSIÓN AJUSTADA
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // Se mantiene
    implementation("androidx.activity:activity-compose:1.7.2") // VERSIÓN AJUSTADA

    // Compose BOM (Bill of Materials) - ayuda a gestionar versiones de Compose
    val composeBomVersion = "2023.08.00" // VERSIÓN AJUSTADA
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    androidTestImplementation(platform("androidx.compose:compose-bom:$composeBomVersion"))

    // Dependencias de Compose (sin especificar versiones individuales gracias al BOM)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3") // Para Material Design 3
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // ViewModel para Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // Se mantiene

    // Icons (Material Icons Extended)
    implementation("androidx.compose.material:material-icons-core") // Ya incluido con material3 usualmente
    implementation("androidx.compose.material:material-icons-extended") // Para más iconos

    // Pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}

