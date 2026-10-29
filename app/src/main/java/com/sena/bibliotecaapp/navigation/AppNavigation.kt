package com.sena.bibliotecaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.bibliotecaapp.ui.screen.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.INICIO) {

        // 1. Pantalla de Inicio
        composable(Routes.INICIO) {
            InicioScreen(
                onVerLibros = { navController.navigate(Routes.LIBROS) },
                onMisReservas = { navController.navigate(Routes.MIS_RESERVAS) }
            )
        }

        // 2. Pantalla de Lista de Libros
        composable(Routes.LIBROS) {
            LibrosScreen(
                onBack = { navController.popBackStack() },
                onVerDetalle = { nombre ->
                    navController.navigate(Routes.detalleLibro(nombre))
                }
            )
        }

        // 3. Pantalla de Detalle de un Libro (Nombre corregido a DetalleLibrosScreen)
        composable(Routes.DETALLE_LIBRO) { backStackEntry ->
            val nombreLibro: String = backStackEntry.arguments?.getString("nombre") ?: "Libro"
            DetalleLibrosScreen(
                nombreLibro = nombreLibro,
                onBack = { navController.popBackStack() },
                onConfirmarReserva = { nombre, fecha ->
                    navController.navigate(Routes.confirmacion(nombre, fecha))
                }
            )
        }

        // 4. Pantalla de Mis Reservas
        composable(Routes.MIS_RESERVAS) {
            MisReservasScreen(
                onBack = { navController.popBackStack() },
                onVerDetalleReserva = { nombre, fecha, codigo ->
                    navController.navigate(Routes.detalleReserva(nombre, fecha, codigo))
                },
                onRenovar = { nombre, fecha, codigo ->
                    navController.navigate(Routes.renovar(nombre, fecha, codigo))
                }
            )
        }

        // 5. Pantalla de Detalle de una Reserva
        composable(Routes.DETALLE_RESERVA) { backStackEntry ->
            val nombre: String = backStackEntry.arguments?.getString("nombre") ?: ""
            val fecha: String = backStackEntry.arguments?.getString("fecha") ?: ""
            val codigo: String = backStackEntry.arguments?.getString("codigo") ?: ""

            DetalleReservaScreen(
                nombre = nombre,
                fecha = fecha,
                codigo = codigo,
                onBack = { navController.popBackStack() }
            )
        }

        // 6. Pantalla para Renovar Préstamo
        composable(Routes.RENOVAR) { backStackEntry ->
            val nombre: String = backStackEntry.arguments?.getString("nombre") ?: ""
            val fecha: String = backStackEntry.arguments?.getString("fecha") ?: ""
            val codigo: String = backStackEntry.arguments?.getString("codigo") ?: ""

            RenovarScreen(
                nombre = nombre,
                fecha = fecha,
                codigo = codigo,
                onRenovacionCompleta = { lib, nuevaFecha ->
                    navController.navigate(Routes.renovacionExitosa(lib, nuevaFecha))
                },
                onBack = { navController.popBackStack() }
            )
        }

        // 7. Pantalla de Renovación Exitosa
        composable(Routes.RENOVACION_EXITOSA) { backStackEntry ->
            val nombre: String = backStackEntry.arguments?.getString("nombre") ?: ""
            val fechaNueva: String = backStackEntry.arguments?.getString("fechaNueva") ?: ""

            RenovacionExitosaScreen(
                nombre = nombre,
                fechaNueva = fechaNueva,
                onIrInicio = {
                    navController.navigate(Routes.INICIO) {
                        popUpTo(Routes.INICIO) { inclusive = true }
                    }
                }
            )
        }
    }
}