package org.example;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Carlos",
                "López", (byte) 58);
        Alumno b = new Alumno("María",
                "Agüelles", (byte) 23);
        Alumno c = new Alumno("Fabio",
                "CIDEP", (byte) 22);
        Alumno d = new Alumno("Carmen",
                "Ruiz", (byte)  30);

        Fichero.escribir(a, "alumnos.bin");
        Fichero.escribir(b, "alumnos.bin");
        Fichero.escribir(c, "alumnos.bin");
        Fichero.escribir(d, "alumnos.bin");
        Alumno e = Fichero.leer("alumnos.bin");
        System.out.println("Jaime Putero");
        System.out.println("Leido: " + e.getNombre() + " "
                + e.getApellidos() + " " + e.getEdad());
    }
}