/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexx
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws Exception {

        File archivo = new File(nombreRecurso);

        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws Exception {

        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String linea = null;
        linea = entrada.readLine();

        while (linea != null) {

            Pelicula pelicula = new Pelicula(linea);
            peliculas.add(pelicula);
            linea = entrada.readLine();
        }
        entrada.close();

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws Exception {

        File archivo = new File(nombreRecurso);
        var salida = new PrintWriter(new FileWriter(archivo, anexar));
        salida.println(pelicula.toString());
        salida.close();
        System.out.println("Se ha ecrito informacion al archivo: " + pelicula);
    }

    @Override
    public String buscar(String nombreRecurso, String buscada) throws Exception {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        var entrada = new BufferedReader(new FileReader(archivo));
        String linea = null;
        linea = entrada.readLine();
        int indice = 1;

        while (linea != null) {

            if (buscada != null && buscada.equalsIgnoreCase(linea)) {

                resultado = "Pelicula " + linea + " encontrada en el indice: " + indice;
                break;
            }
            linea = entrada.readLine();
            indice++;
        }
        entrada.close();

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws Exception {
        
        var archivo = new  File(nombreRecurso);
        var salida = new PrintWriter(new FileWriter(archivo));
        salida.close();
        System.out.println("Se ha creado el archivo");
        
    }

    @Override
    public void borrar(String nombreRecurso) throws Exception {
        var archivo = new  File(nombreRecurso);
        if(archivo.exists()){
        
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
        
    }

}
