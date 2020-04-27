/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author rcgr
 */
public class AgregarAutor extends JFrame {
    public AgregarAutor()
    {
        /*
        Variable        Tipo        Uso
        btnAgregar      JButton     Es el boton para terminar la funcion y 
                                    agregar lo que este en txtNombre.
        lbNombre        JLabel      Es la etiqueta que describe como se
                                    interpretara lo que este en txtNombre.
        txtNombre       JTextField  Es el campo donde se debe introducir el
                                    nombre del autor.
        p1              JPanel      Es uno de los contenedores de los elementos.
        p2              JPanel      Es uno de los contenedores de los elementos.
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
                
        JPanel p1 = new JPanel(new GridLayout(0, 2));
        JPanel p2 = new JPanel();
        
        JButton btnAgregar = new JButton("Agregar");
        JButton btnRegresar = new JButton("Regresar");
        
        JLabel lbNombre = new JLabel("Nombre");
        JTextField txtNombre = new JTextField("");
        
        btnAgregar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(txtNombre.getText());
            }
        });
        
        btnRegresar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed();
            }
        });
        
        p1.add(lbNombre);
        p1.add(txtNombre);
        p2.add(btnRegresar);
        p2.add(btnAgregar);
                
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
    }
    
    private void btnAgregarActionPerformed(String nombre)
    {
        /*
        Variable        Tipo        Uso
        nombre          String      Nombre que se recibe del campo de texto en
                                    AgregarAutor().
        i               int         Saber en que posicion del arreglo 
                                    ProyectoPOO.autores[] va dentro del ciclo.
        confirmar       boolean     Saber si ya se asigno el nombre o no.
        */
        try
        {
            int i=0;
            boolean confirmar = false;
            
            while(!confirmar)
            {   
                if(ProyectoPOO.autores[i].get_disponible())
                {                            
                    ProyectoPOO.autores[i].put_nombre(nombre);
                    ProyectoPOO.autores[i].put_disponible(false);
                    confirmar = true;
                }
                else
                    i++;
                
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(this, "Todos los espacios estan "+
                    "llenos.\nSi desea agregar otro autor debe de borrar algun"
                    + "o.");
        }
        
        new ProyectoPOO();
        this.setVisible(false);
    }
    
    private void btnRegresarActionPerformed()
    {
        new ProyectoPOO();
        this.setVisible(false);
    }
}
