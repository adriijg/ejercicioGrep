package es.tierno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ComandoGrep {

    private static final String[] LINEAS = {
        "Me gusta PSP y java",
        "PSP se programa en java",
        "es un módulo de DAM",
        "y se programa de forma concurrente en PSP",
        "PSP es programación."
    };
    private static final String PARAMETRO = "PSP";
    private static final String COMANDO = "grep";

    public static void main(String[] args) {
        try {
            Process proceso = crearProceso(COMANDO, PARAMETRO);
            escribirLineas(proceso, LINEAS);
            leerSalida(proceso);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Process crearProceso(String comando, String parametro) throws IOException {
        return new ProcessBuilder(comando, parametro).start();
    }

    private static void escribirLineas(Process proceso, String[] lineas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(proceso.getOutputStream()))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        }
    }

    private static void leerSalida(Process proceso) throws IOException, InterruptedException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }
        int exitCode = proceso.waitFor();
        System.out.println("El proceso terminó con código: " + exitCode);
    }
}
