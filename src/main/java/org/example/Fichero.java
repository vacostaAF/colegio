package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Fichero {
    static final int TAM_REGISTRO_CHARS=60;

    public static void escribir2(Alumno a, String f)
    {
        try {

            Path fichero = Paths.get(f);
            BufferedWriter bw = Files.newBufferedWriter(fichero,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            bw.write(a.toString());
            bw.write(a.getEdad());

            bw.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void escribir(Alumno a, String fichero)
    {
        try {
            File f = new File(fichero);
            f.delete();
            RandomAccessFile raf =
                    new RandomAccessFile(f, "rw");

            raf.writeChars(a.toString());
            raf.writeByte(a.getEdad());

            raf.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static Alumno leer(String fichero)
    {
        try {
            Alumno a;
            File f = new File(fichero);
            String datosChar="";
            byte edad = 0;
            RandomAccessFile raf =
                    new RandomAccessFile(f, "rw");

            for(int i=0;i<TAM_REGISTRO_CHARS; i++) {
                datosChar = datosChar + raf.readChar();
                //System.out.println(datosChar);
            }

            edad = raf.readByte();

            //Cargar alumno
            a = new Alumno(datosChar.substring(0,29).trim(),
                    datosChar.substring(30, 59).trim(),
                    edad);

            return a;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }

    }
}
