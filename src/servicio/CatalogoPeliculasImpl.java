/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import domain.Pelicula;

/**
 *
 * @author Alexx
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {

        Pelicula pelicula = new Pelicula(nombrePelicula);

        boolean anexar = false;

        try {

            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);

        } catch (Exception ex) {
            System.out.println("Error de accesoa datos");
            ex.printStackTrace();
        }

    }

    @Override
    public void listarPeliculas() {

        try {

            var peliculas = datos.listar(NOMBRE_RECURSO);

            for (var pelicula : peliculas) {

                System.out.println("pelicula = " + pelicula);
            }

        } catch (Exception ex) {

            ex.printStackTrace();

            System.out.println("Error acceso datos");

        }
    }

    @Override
    public void buscarPelicula(String nombre) {

        String resultado = null;

        try {

            resultado = this.datos.buscar(NOMBRE_RECURSO, nombre);
            System.out.println("Resultado: " + resultado);

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Error al buscar pelicula");

        }

    }

    @Override
    public void iniciarCatalogoPeliculas() {

        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {

                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crear(NOMBRE_RECURSO);

            } else {

                this.datos.crear(NOMBRE_RECURSO);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al crear catalogo de peliculas");
        }

    }

}
