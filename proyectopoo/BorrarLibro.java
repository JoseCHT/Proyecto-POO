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
public class BorrarLibro extends JFrame {
    public BorrarLibro()
    {
        /*
        Variable        Tipo        Uso
        
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel(new GridLayout(0,2));
        JPanel p2 = new JPanel();
       
        JButton btnBorrar = new JButton("Borrar");
        JButton btnRegresar = new JButton("Regresar");
        
        for(int i=0;i<ProyectoPOO.libros.length;i++)
        {
            if(ProyectoPOO.libros[i].get_disponible())
                cbLibros[i] = new JCheckBox("No existe");
            else
                cbLibros[i] = new JCheckBox(ProyectoPOO.libros[i].get_titulo());    
            
            p1.add(cbLibros[i]);
        }
        
        btnBorrar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        
        btnRegresar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
                
        p2.add(btnRegresar);
        p2.add(btnBorrar);
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt)
    {
        for(int i=0;i<ProyectoPOO.editoriales.length;i++)
        {
            if(cbLibros[i].isSelected())
            {
                ProyectoPOO.libros[i].put_titulo("");
                ProyectoPOO.libros[i].put_publicacion(1,0,1);
                ProyectoPOO.libros[i].put_editorial(new Editorial());
                ProyectoPOO.libros[i].put_autor(new Autor());
                ProyectoPOO.libros[i].put_disponible(true);
            }
        }
        
        new ProyectoPOO();
        this.setVisible(false);
    }
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt)
    {        
        new ProyectoPOO();
        this.setVisible(false);
    }
    
    private JCheckBox cbLibros[] = new JCheckBox[ProyectoPOO.libros.length];    
}
