# Parcial I - Parte practica G412

### Integrantes:
- **Jean Paul Rojas Herrera**
- **Michael Dowglas Lenis Chaguendo**

## Diagrama de Clases (Mermaid)

```mermaid
classDiagram
    class Libro {
        - titulo: String
        - autor: String
        - numeroEjemplares: int
        - numeroEjemplaresPrestados: int
        + «constructor» Libro()
        + «constructor» Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados)
        + getTitulo() String
        + setTitulo(String titulo)
        + getAutor() String
        + setAutor(String autor)
        + getNumeroEjemplares() int
        + setNumeroEjemplares(int numeroEjemplares)
        + getNumeroEjemplaresPrestados() int
        + setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados)
        + prestamo() boolean
        + devolucion() boolean
        + toString() String
    }
    class LibroTexto {
        - curso: String
        + «constructor» LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso)
        + getCurso() String
        + setCurso(String curso)
        + toString() String
    }
    class Novela {
        - tipo: String
        + «constructor» Novela(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String tipo)
        + getTipo() String
        + setTipo(String tipo)
        + toString() String
    }
    class LibroTextoUNIAC {
        - facultad: String
        + «constructor» LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso, String facultad)
        + getFacultad() String
        + setFacultad(String facultad)
        + toString() String
    }
    Libro <|-- LibroTexto : extends
    Libro <|-- Novela : extends
    LibroTexto <|-- LibroTextoUNIAC : extends
```

## Dos situaciones donde NO sería posible la herencia:

**Situación 1 - Atributos privados:** Los atributos de Libro son private, lo que significa que las clases hijas no pueden acceder directamente a ellos, solo a través de los getters y setters. 

```
// Esto fallaría en LibroTexto:
public String toString() {
    return titulo; // ERROR: titulo es private en Libro
}
// Debe hacerse así:
    return getTitulo(); // Correcto, usando el getter
```

**Situación 2 — Si la clase fuera final:** Si Libro estuviera declarada como final, ninguna clase podría heredar de ella. 

```
public final class Libro { // Con esto, LibroTexto, Novela, etc. NO podrían existir
}
```

## Dos nuevos atributos y un método adicional con sentido:

```
// En clase Libro: fecha de publicación y editorial
private int anioPublicacion;
private String editorial;

// Getters y setters correspondientes...

// Método adicional: verificar si el libro es antiguo (más de 20 años)
public boolean esLibroAntiguo() {
    int anioActual = java.time.Year.now().getValue();
    return (anioActual - anioPublicacion) > 20;
}
```

Estos tienen sentido porque una biblioteca real siempre cataloga el año de publicación y la editorial, y saber si un libro es antiguo puede ser útil para decisiones de adquisición de nuevas copias.