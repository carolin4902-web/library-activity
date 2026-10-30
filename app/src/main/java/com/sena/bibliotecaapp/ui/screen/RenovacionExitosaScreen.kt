package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RenovacionExitosaScreen(
    nombre: String,
    fechaNueva: String,
    onIrInicio: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "✅ ¡Renovación Exitosa!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("El libro '$nombre' ha sido renovado.")
            Text("Nueva fecha límite: $fechaNueva")

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onIrInicio, modifier = Modifier.fillMaxWidth()) {
                Text("Volver al Inicio")
            }
        }
    }
}