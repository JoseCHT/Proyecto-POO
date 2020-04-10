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
public class Editorial {
    /*
    OBJETO EDITORIAL
    Variable    Tipo        Uso
    nombre      String      Almacena el nombre de la editorial.
    lugar       String      Almacena el lugar donde esta la editorial.
    */
    private String nombre="", lugar="";
    private boolean diponible = true;
    
    public void put_nombre(String in_nombre)
    {
        this.nombre = in_nombre;
    }
    
    public void put_lugar(String in_lugar)
    {
        this.lugar = in_lugar;
    }
    
    public void put_disponible(boolean in_disponible)
    {
        this.diponible = in_disponible;
    }
    
    public String get_nombre()
    {
        return this.nombre;
    }
    
    public String get_lugar()
    {
        return this.lugar;
    }
    
    public boolean get_disponible()
    {
        return this.diponible;
    }
}
