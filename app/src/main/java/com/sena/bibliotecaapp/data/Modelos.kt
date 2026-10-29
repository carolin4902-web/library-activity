package com.sena.bibliotecaapp.data

data class Libro(
    val nombre: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

data class Reserva(
    val nombreLibro: String,
    val fecha: String,
    val codigo: String,
    val estado: String = "Activa"
)