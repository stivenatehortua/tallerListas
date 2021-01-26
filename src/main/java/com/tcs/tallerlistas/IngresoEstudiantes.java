package com.tcs.tallerlistas;

import com.tcs.tallerlistas.beans.Estudiante;
import com.tcs.tallerlistas.beans.Excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.tcs.tallerlistas.beans.Constantes.*;


public class IngresoEstudiantes {


    public static void main(String[] args) {

        System.out.println("               ¡¡¡¡¡Ingreso de estudiantes!!!!!                 ");

        List<Estudiante> list;

        try {

            list = obtenerEstudiantes();

            System.out.println("Estudiantes registrados: " + list.size() + " estudiantes");

            try {
                validarEdad(6, 10, list);
            } catch (Excepciones excepciones) {
                System.out.println(CODIGO + excepciones.getCodigo());
                System.out.println(ERROR + excepciones.getError());
                System.out.println(CAUSA + excepciones.getCausa());
            }

            asignarEstudiantes(list);
            estudiantesReprobados(list);

        } catch (Excepciones excepciones) {
            System.out.println(CODIGO + excepciones.getCodigo());
            System.out.println(CAUSA + excepciones.getCausa());
            System.out.println(ERROR + excepciones.getError());
        }
    }

    public static List<Estudiante> obtenerEstudiantes() throws Excepciones {

        List<Estudiante> list = new ArrayList<>();
        Estudiante estudiante;
        try {
            Scanner data = new Scanner(new File(RUTA_DATA));

            while (data.hasNextLine()) {
                String[] estData = data.nextLine().split(",");
                estudiante = new Estudiante(estData[0], estData[1], estData[2], estData[3], estData[4]);
                list.add(estudiante);
            }
        } catch (FileNotFoundException e) {
            throw new Excepciones("E01", "el archivo en la ruta " + e.getMessage() +
                    " no existe", " " + e.getCause());
        }
        return list;
    }

    public static void validarEdad(int edadInicial, int edadFinal, List<Estudiante> list) throws Excepciones {
        int contEdad = 0;
        for (Estudiante estudiante : list) {
            try {
                if (Integer.parseInt(estudiante.getEdad()) >= edadInicial && Integer.parseInt(estudiante.getEdad()) <= edadFinal)
                    contEdad++;
            } catch (NumberFormatException e) {
                throw new Excepciones("E02", "La edad obtenida no tiene el formato numerico " + e.getMessage(), "" + e.getCause());
            }
        }
        System.out.println("Estudiantes entre " + edadInicial + " y " + edadFinal + " años, son: " + contEdad + " estudiantes");
    }

    public static void asignarEstudiantes(List<Estudiante> list) {

        List<Estudiante> listaPrescolar = new ArrayList<>();
        List<Estudiante> listaPrimerGrado = new ArrayList<>();
        List<Estudiante> listaSegundoGrado = new ArrayList<>();
        List<Estudiante> listaTercerGrado = new ArrayList<>();
        List<Estudiante> listaCuartoGrado = new ArrayList<>();
        List<Estudiante> listaQuintoGrado = new ArrayList<>();

        list.forEach(estudiante -> {
            String curso = estudiante.getGrado();
            switch (curso) {

                case JARDIN:
                    listaPrescolar.add(estudiante);
                    break;

                case PRIMER_GRADO:
                    listaPrimerGrado.add(estudiante);
                    break;

                case SEGUNDO_GRADO:
                    listaSegundoGrado.add(estudiante);
                    break;

                case TERCER_GRADO:
                    listaTercerGrado.add(estudiante);
                    break;

                case CUARTO_GRADO:
                    listaCuartoGrado.add(estudiante);
                    break;

                case QUINTO_GRADO:
                    listaQuintoGrado.add(estudiante);
                    break;

                default:
                    System.out.println("Grado no valido");
            }
        });

        imprimirGrado(listaPrescolar, JARDIN);
        imprimirGrado(listaPrimerGrado, PRIMER_GRADO);
        imprimirGrado(listaSegundoGrado, SEGUNDO_GRADO);
        imprimirGrado(listaTercerGrado, TERCER_GRADO);
        imprimirGrado(listaCuartoGrado, CUARTO_GRADO);
        imprimirGrado(listaQuintoGrado, QUINTO_GRADO);
    }

    public static boolean validarTipoId(String id) {
        String subCadena = id.substring(0, 2);
        return (subCadena.equals("TI"));
    }

    public static void imprimirGrado(List<Estudiante> list, String grado) {
        System.out.println("\n" + grado);
        list.forEach(estudiante -> {
            String cadena = estudiante.getNombre();
            if (validarTipoId(estudiante.getId()))
                cadena += " " + estudiante.getEdad() + ANOS_Y_GRADO + estudiante.getGrado();
            System.out.println(cadena);
        });
    }

    public static void estudiantesReprobados(List<Estudiante> list) {

        System.out.println("\nLos siguientes estudiantes reprobaron el grado:");

        list.forEach(estudiante -> {
            if (estudiante.getAprobado().equals(ESTUDIANTE_REPROBADO)) {
                System.out.println("Estidiante: " + estudiante.getNombre() + ", Grado: " + estudiante.getGrado());
            }
        });
    }
}

