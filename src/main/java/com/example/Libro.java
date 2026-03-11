package com.example;

public class Libro {
    
    private String titulo;
    private String autor;
    private int numeroEjemplares;
    private int numeroEjemplaresPrestados;

    // Constructor vacio.
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.numeroEjemplares = 0;
        this.numeroEjemplaresPrestados = 0;
    }

    // Constructor con parametros.
    public Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroEjemplares = numeroEjemplares;
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    // Getters y Setters.
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public int getNumeroEjemplaresPrestados() {
        return numeroEjemplaresPrestados;
    }

    public void setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) {
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    // Método para prestar un libro.
    public boolean prestamo() {
        int disponibles = numeroEjemplares - numeroEjemplaresPrestados;
        if(disponibles > 0) {
            numeroEjemplaresPrestados++;
            return true; // Retorna true si el préstamo fue exitoso.
        } else {
            return false; // Retorna false si no hay ejemplares disponibles para prestar.
        }
    }

    // Método para devolver un libro.
    public boolean devolucion() {
        if(numeroEjemplaresPrestados > 0) {
            numeroEjemplaresPrestados--;
            return true; // Retorna true si la devolución fue exitosa.
        } else {
            return false; // Retorna false si no hay ejemplares prestados para devolver.
        }
    }

    // Método para imprimir la información del libro.
    @Override
    public String toString() {
        return "Título: " + titulo +
               "\nAutor: " + autor +
               "\nNúmero de ejemplares: " + numeroEjemplares +
               "\nEjemplares prestados: " + numeroEjemplaresPrestados +
               "\nEjemplares disponibles: " + (numeroEjemplares - numeroEjemplaresPrestados);
    }
}