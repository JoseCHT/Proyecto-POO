/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import java.util.*;

/**
 *
 * @author rcgr
 */
public class Libro {
    /*
    OBJETO LIBRO
    Variable    Tipo        Uso
    titulo      String      Almacena el nombre del libro.
    publicacion Date        Almacena la fecha publicacion del libro.
    editorial   Editorial   Almacena el la editorial que publico el libro.
    autor       Autor       Almacena al autor que publico el libro.
    */
    private String titulo="";
    private Calendar publicacion = Calendar.getInstance();
    private Editorial editorial;
    private Autor autor;
    private boolean disponible=true;
    
    public void put_titulo(String in_titulo)
    {
        this.titulo = in_titulo;
    }
    
    public void put_autor(Autor in_autor)
    {
        this.autor = in_autor;
    }
    
    public void put_publicacion(int in_dia, int in_mes, int in_anio)
    {
        this.publicacion.set(in_anio, in_mes, in_dia);
    }
    
    public void put_editorial(Editorial in_editorial)
    {
        this.editorial = in_editorial;
    }
    
    public void put_disponible(boolean in_disponible)
    {
        this.disponible = in_disponible;
    }
    
    public void put_datos(String in_titulo, Autor in_autor)
    {
        this.titulo = in_titulo;
        this.autor = in_autor;
    }
    
    public void put_datos(String in_titulo, Autor in_autor, Editorial in_editorial)
    {
        this.titulo = in_titulo;
        this.autor = in_autor;
        this.editorial = in_editorial;
    }
    
    public void put_datos(String in_titulo, Autor in_autor, Editorial in_editorial, Calendar in_publicacion)
    {
        this.titulo = in_titulo;
        this.autor = in_autor;
        this.editorial = in_editorial;
        this.publicacion = in_publicacion;
    }
    
    public String get_titulo()
    {
        return this.titulo;
    }
    
    public Autor get_autor()
    {
        return this.autor;
    }
    
    public Calendar get_publicacion()
    {
        return this.publicacion;
    }
    
    public Editorial get_editorial()
    {
        return this.editorial;
    }
    
    public boolean get_disponible()
    {
        return this.disponible;
    }
}
