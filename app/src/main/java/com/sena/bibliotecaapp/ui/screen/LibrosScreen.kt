package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.ui.composable.LibroItem
import com.sena.bibliotecaapp.ui.composable.TopBar

@Composable
fun LibrosScreen(onVerDetalle: (String) -> Unit, onBack: () -> Unit) {
    val libros = listOf(
        "Clean Code",
        "Kotlin para Android",
        "Arquitectura de Software",
        "Jetpack Compose"
    )

    Scaffold(topBar = { TopBar("Mis Libros", onBack) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Elige un libro para ver más detalles.")
            Spacer(Modifier.height(8.dp))
            LazyColumn {
                items(libros) { nombre ->
                    LibroItem(nombre) { onVerDetalle(nombre) }
                }
            }
        }
    }
}