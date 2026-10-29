package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(
    onVerLibros: () -> Unit,
    onMisReservas: () -> Unit // <--- Agrega este parámetro
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "¡Bienvenido a tu Biblioteca!",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Descubre, aprende y reserva tus libros favoritos.",
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(24.dp))

            Button(
                onClick = onVerLibros,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Libros")
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = onMisReservas,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mis Reservas")
            }
        }
    }
}