package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetalleLibrosScreen(
    nombreLibro: String,
    onBack: () -> Unit,
    onConfirmarReserva: (String, String) -> Unit
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
            Text(
                text = "📖 $nombreLibro",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Autor: Robert C. Martin")
            Text("Estado: Disponible para préstamo")

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onConfirmarReserva(nombreLibro, "15-06-2026") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Reservar Libro")
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}