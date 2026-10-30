package com.sena.bibliotecaapp.navigation

import android.net.Uri

object Routes {
    const val INICIO = "inicio"
    const val LIBROS = "libros"
    const val DETALLE_LIBRO = "detalle_libro/{nombre}"
    const val CONFIRMACION = "confirmacion/{nombre}/{fecha}"
    const val MIS_RESERVAS = "mis_reservas"
    const val DETALLE_RESERVA = "detalle_reserva/{nombre}/{fecha}/{codigo}"
    const val RENOVAR = "renovar/{nombre}/{fecha}/{codigo}"
    const val RENOVACION_EXITOSA = "renovacion_exitosa/{nombre}/{fechaNueva}"

    fun detalleLibro(nombre: String) = "detalle_libro/${Uri.encode(nombre)}"

    fun confirmacion(nombre: String, fecha: String) =
        "confirmacion/${Uri.encode(nombre)}/${Uri.encode(fecha)}"

    fun confirmacion(nombre: String, fecha: String, codigo: String) =
        "confirmacion/${Uri.encode(nombre)}/${Uri.encode(fecha)}/${Uri.encode(codigo)}"

    fun renovar(nombre: String, fecha: String, codigo: String) =
        "renovar/${Uri.encode(nombre)}/${Uri.encode(fecha)}/${Uri.encode(codigo)}"

    fun renovacionExitosa(nombre: String, fechaNueva: String) =
        "renovacion_exitosa/${Uri.encode(nombre)}/${Uri.encode(fechaNueva)}"

    fun detalleReserva(nombre: String, fecha: String, codigo: String) =
        "detalle_reserva/${Uri.encode(nombre)}/${Uri.encode(fecha)}/${Uri.encode(codigo)}"
}