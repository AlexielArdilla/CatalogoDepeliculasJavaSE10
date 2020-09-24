/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import java.util.List;

/**
 *
 * @author Alexx
 */
public interface AccesoDatos {
    
    boolean existe(String nombreRecurso) throws Exception;
    
    List<Pelicula> listar(String nombreRecurso)throws Exception;
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws Exception;
    
    String buscar(String nombreRecurso, String buscada) throws Exception;
    
    void crear(String nombreRecurso) throws Exception;
    
    void borrar(String nombreRecurso) throws Exception; 
    
}
