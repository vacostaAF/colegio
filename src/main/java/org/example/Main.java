package org.example;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Carlos",
                "López", (byte) 58);
        System.out.println(a);

        Fichero.escribir(a, "alumnos.bin");
        Alumno b = Fichero.leer("alumnos.bin");
        System.out.println("Leido: " + b.getNombre() + " "
                + b.getApellidos() + " " + b.getEdad());
    }
}