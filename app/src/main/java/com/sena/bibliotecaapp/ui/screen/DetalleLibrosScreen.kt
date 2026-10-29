package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.ui.composable.TopBar

@Composable
fun DetalleLibroScreen(nombre: String, onReservar: (String) -> Unit, onBack: () -> Unit) {
    val fecha = "15-06-2026"
    val autor = when (nombre) {
        "Clean Code" -> "Robert C. Martin"
        "Kotlin para Android" -> "Equipo Android"
        "Arquitectura de Software" -> "Varios autores"
        else -> "Equipo Android"
    }

    Scaffold(topBar = { TopBar("Detalle del Libro", onBack) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Parámetro recibido: $nombre", color = MaterialTheme.colorScheme.tertiary)
            Spacer(Modifier.height(16.dp))
            Text("Nombre: $nombre")
            Text("Autor: $autor")
            Text("Categoría: Programación")
            Spacer(Modifier.height(8.dp))
            Text("Descripción:", style = MaterialTheme.typography.titleSmall)
            Text("Guía práctica para escribir código limpio, legible y mantenible.")
            Spacer(Modifier.weight(1f))
            Button(
                onClick = { onReservar(fecha) },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Reservar Libro") }
        }
    }
}