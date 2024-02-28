package com.example.examendit2.Modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de prueba para la clase Biblioteca.
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    /**
     * Prueba la función de prestar un libro que no existe en la biblioteca.
     */
    @Test
    public void testPrestarLibroNoExistente() {
        assertFalse(biblioteca.prestar(1, "123456789")); // Suponiendo que no existe el libro con Id 1
    }
    /**
     * Prueba la función de prestar a un usuario que no existe en la biblioteca.
     */
    @Test
    public void testPrestarUsuarioNoExistente() {
        biblioteca.altaLibro(1, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-01-01"));
        assertFalse(biblioteca.prestar(1, "123456789")); // Suponiendo que no existe el usuario con Dni "123456789"
    }
    /**
     * Prueba la función de prestar un libro a un usuario existente en la biblioteca.
     */
    @Test
    public void testPrestarLibroYUsuarioExistentes() {
        biblioteca.altaLibro(1, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-01-01"));
        biblioteca.altaLibro(2, "Otro Libro", "ISBN456", "Otro Autor", "Científico", LocalDate.parse("2022-01-01"));
        biblioteca.altaLibro(3, "Libro Sancionado", "ISBN789", "Sancionado Autor", "Revista", LocalDate.parse("2022-01-01"));

        biblioteca.prestar(1, "123456789"); // Suponiendo que el usuario con Dni "123456789" existe

        assertTrue(biblioteca.prestar(2, "123456789")); // Prestar a un usuario existente
        assertFalse(biblioteca.prestar(3, "123456789")); // Usuario sancionado
    }

    /**
     * Prueba la función de prestar un libro a un usuario existente en la biblioteca.
     */
    @Test
    public void testDevolverEnFecha() {
        biblioteca.altaLibro(1, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-02-26"));

        biblioteca.prestar(1, "123456789");

        assertTrue(biblioteca.devolver(1, "123456789")); // Devolver en fecha
    }

    /**
     * Prueba la función de devolver un libro fuera de fecha.
     */
    @Test
    public void testDevolverFueraDeFecha() {
        biblioteca.altaLibro(1, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-01-01"));

        biblioteca.prestar(1, "123456789");

        // Simulamos el paso de 15 días desde el préstamo
        LocalDate fechaDevolucionFueraDeFecha = LocalDate.parse("2022-01-16");

        // Modificamos la fecha de devolución en el objeto de préstamo
        Prestamo prestamo = Prestamo.buscarPrestamo(biblioteca.getPrestamos(), 1, "123456789");

        if (prestamo != null) {
            prestamo.setFechaDevolucion(fechaDevolucionFueraDeFecha);
            assertFalse(biblioteca.devolver(1, "123456789")); // Devolver fuera de fecha
        } else {
            // Manejar el caso cuando el préstamo no se encuentra
            fail("El préstamo no se encontró.");
        }
    }
    /**
     * Prueba la función de alta de libro, asegurando que atributos únicos no se repitan.
     */
    @Test
    public void testAltaLibroAtributosUnicosNoRepetidos() {
        assertTrue(biblioteca.altaLibro(1, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-01-01"))); // Primer alta exitosa
        assertFalse(biblioteca.altaLibro(1, "Otro Libro", "ISBN456", "Otro Autor", "Científico", LocalDate.parse("2022-01-01"))); // Id repetido
        assertFalse(biblioteca.altaLibro(2, "Libro Ejemplo", "ISBN123", "Autor Ejemplo", "Novela", LocalDate.parse("2022-01-01"))); // ISBN repetido
    }
}
