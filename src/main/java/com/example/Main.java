package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Objeto libro1 que utiliza el constructor con parámetros.
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 1);

        // Objeto libro2 que utiliza el constructor vacío y luego se asignan los valores mediante consola.
        Libro libro2 = new Libro();
        System.out.println("=== Ingrese datos para libro2 ===");
        System.out.print("Título: ");
        libro2.setTitulo(sc.nextLine());
        System.out.print("Autor: ");
        libro2.setAutor(sc.nextLine());
        System.out.print("Número de ejemplares: ");
        libro2.setNumeroEjemplares(sc.nextInt());
        System.out.print("Ejemplares prestados: ");
        libro2.setNumeroEjemplaresPrestados(sc.nextInt());
        sc.nextLine();

        // Libro de texto UNIAC que indica todos sus atributos, incluyendo el curso asociado y la facultad a la que pertenece.
        LibroTextoUNIAC libroTextoUNIAC = new LibroTextoUNIAC("Fundamentos de POO", "Bruce Eckel", 8, 2, "Programación Orientada a Objetos", "Ingeniería de Sistemas");

        // Novela que indica todos sus atributos, incluyendo el tipo de novela.
        Novela novela = new Novela("Dune", "Frank Herbert", 4, 0, "Ciencia ficción");

        // Impresión de la información.
        System.out.println("\n========== Libro 1 ==========");
        System.out.println(libro1.toString());

        System.out.println("\n========== Libro 2 ==========");
        System.out.println(libro2.toString());

        System.out.println("\n========== LibroTextoUNIAC ==========");
        System.out.println(libroTextoUNIAC.toString());

        System.out.println("\n========== Novela ==========");
        System.out.println(novela.toString());

        System.out.println("\n========== Prueba de Préstamo y Devolución ==========");

        System.out.println("\n-- Préstamo libro1 --");
        boolean resultadoPrestamo = libro1.prestamo();
        System.out.println("¿Préstamo exitoso? " + (resultadoPrestamo ? "Sí" : "No"));
        System.out.println(libro1.toString());

        System.out.println("\n-- Devolución libro1 --");
        boolean resultadoDevolucion = libro1.devolucion();
        System.out.println("¿Devolución exitosa? " + (resultadoDevolucion ? "Sí" : "No"));
        System.out.println(libro1.toString());

        sc.close();
    }
}