package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RenovarScreen(
    nombre: String,
    fecha: String,
    codigo: String,
    onRenovacionCompleta: (String, String) -> Unit,
    onBack: () -> Unit
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
            Text(text = "🔄 Renovar Préstamo", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("¿Deseas extender el plazo para: $nombre?")
            Text("Fecha actual: $fecha")

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { onRenovacionCompleta(nombre, "30-06-2026") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar Renovación")
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Cancelar")
            }
        }
    }
}