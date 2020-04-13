/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.*;
import java.awt.*;

public class BorrarEditorial extends JFrame{
    public BorrarEditorial()
    {
        /*
        Variable        Tipo            Uso
        btnBorrar       JButton         Es el botón que termina la función una 
                                        vez seleccionados los autores.
        btnRegresar     JButton         Botón que cancela la acción y devuelve el 
                                        menú principal. 
        p1              JPanel          Es uno de los contenedores de los elementos.
        p2              JPanel          Es uno de los contenedores de los elementos.
        i               int             Conocer la posición de la editorial seleccionada. 
        cbEditorial     JCheckBox       Opción que permite colocar un listado de las 
                                        que se puede seleccionar por medio de cajas.
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel(new GridLayout(0,2));
        JPanel p2 = new JPanel();
       
        JButton btnBorrar = new JButton("Borrar");
        JButton btnRegresar = new JButton("Regresar");
        
        for(int i=0;i<ProyectoPOO.editoriales.length;i++)
        {
            if(ProyectoPOO.editoriales[i].get_disponible())
                cbEditorial[i] = new JCheckBox("No existe");
            else
                cbEditorial[i] = new JCheckBox(ProyectoPOO.editoriales[i].get_nombre());    
            
            p1.add(cbEditorial[i]);
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
            if(cbEditorial[i].isSelected())
            {
                ProyectoPOO.editoriales[i].put_nombre("");
                ProyectoPOO.editoriales[i].put_lugar("");
                ProyectoPOO.editoriales[i].put_disponible(true);
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
    
    private JCheckBox cbEditorial[] = new JCheckBox[ProyectoPOO.editoriales.length];    
}
