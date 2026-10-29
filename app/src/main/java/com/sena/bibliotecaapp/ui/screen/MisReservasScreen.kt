package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MisReservasScreen(
    onBack: () -> Unit,
    onVerDetalleReserva: (String, String, String) -> Unit,
    onRenovar: (String, String, String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "📚 Mis Reservas",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo estático de una reserva simulada
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Libro: Clean Code", style = MaterialTheme.typography.titleMedium)
                    Text("Fecha límite: 15-06-2026")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(onClick = {
                            onVerDetalleReserva("Clean Code", "15-06-2026", "LIB-001")
                        }) {
                            Text("Detalle")
                        }
                        Button(onClick = {
                            onRenovar("Clean Code", "15-06-2026", "LIB-001")
                        }) {
                            Text("Renovar")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Volver al Inicio")
            }
        }
    }
}