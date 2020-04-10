/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

/**
 *
 * @author rcgr
 */
public class Autor {
    /*
    OBJETO AUTOR
    Variable    Tipo    Uso
    nombre      String  Almacena el nombre del autor.
    disponible  boolean Almacena un valor que indica si espacio esta disponible
                        para llenar o no.
    */
    private String nombre = "";
    private boolean disponible = true;
    
    public void put_nombre(String in_nombre)
    {
        this.nombre = in_nombre;
    }
    
    public void put_disponible(boolean in_disponible)
    {
        this.disponible = in_disponible;
    }
    
    public String get_nombre()
    {
        return this.nombre;
    }
    
    public boolean get_disponible()
    {
        return this.disponible;
    }
}
