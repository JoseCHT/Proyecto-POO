/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rcgr
 */
public class VentanaAcciones extends JFrame {
    public VentanaAcciones(int op)
    {
        /*
        Ventana acciones espera recibir una variable de tipo entero para saber
        si se quiere trabajar con un objeto de tipo Editorial, Libro, Autor, 
        Personas o Prestamos.
        
        Variable        Tipo        Uso
        btnAgregar      JButton     Sirve como el boton para agregar.
        btnBorrar       JButton     Sirve como el boton para borrar.
        btnCambios      JButton     Sirve como el boton para hacer cambios.
        btnRegresar     JButton     Sirve como el boton para regresar.
        p1              JPanel      Es el contenedor de los elementos.
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        
        JPanel p1 = new JPanel(new GridLayout(0, 1));
        
        JButton btnAgregar = new JButton("Agregar"); 
        btnAgregar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(op);
            }
        });
        
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(op);
            }
        });
        
        JButton btnCambios = new JButton("Cambios");
        btnCambios.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiosActionPerformed(op);
            }
        });
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed();
            }
        });
        
        p1.setSize(400, 600);
        p1.add(btnAgregar);
        p1.add(btnBorrar);
        p1.add(btnCambios);
        p1.add(btnRegresar);
        
        add(p1);
        
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private void btnAgregarActionPerformed(int op)
    {
        switch(op)
        {
            case 0:
                this.setVisible(false);
                new AgregarEditorial();
                break;
            
            case 1:
                this.setVisible(false);
                new AgregarAutor();                
                break;
            
            case 2:
                this.setVisible(false);
                new AgregarLibro();
                break;                           
        }
    }
    
    private void btnBorrarActionPerformed(int op)
    {
        switch(op)
        {
            case 0:
                this.setVisible(false);
                new BorrarEditorial();
                break;
            
            case 1:
                this.setVisible(false);
                new BorrarAutor();                
                break;
            
            case 2:
                this.setVisible(false);
                new BorrarLibro();
                break;
        }
    }
    
    private void btnCambiosActionPerformed(int op)
     {
        switch(op)
        {
            case 0:
                this.setVisible(false);
                new ElegirEditorial();
                break;
            
            case 1:
                this.setVisible(false);
                new ElegirAutor();                
                break;
            
            case 2:
                this.setVisible(false);
                new ElegirLibro();
                break;
        }
    }       
    
    private void btnRegresarActionPerformed()
    {
        new ProyectoPOO();
        this.setVisible(false);
    }
}
