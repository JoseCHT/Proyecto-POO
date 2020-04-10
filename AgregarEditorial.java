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
public class AgregarEditorial extends JFrame{
    public AgregarEditorial()
    {
        /*
        Variable        Tipo        Uso
        btnAgregar      JButton     Es el boton para terminar la funcion y 
                                    agregar lo que este en txtNombre.
        lbNombre        JLabel      Es la etiqueta que describe como se
                                    interpretara lo que este en txtNombre.
        txtNombre       JTextField  Es el campo donde se debe introducir el
                                    nombre de la Editorial.
        lbLugar         JLabel      Es la etiqueta que describe como se
                                    interpretara lo que este en txtLugar.
        txtLugar        JTextField  Es el campo donde se debe introducir el
                                    lugar de la Editorial.
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
        JLabel lbLugar = new JLabel("Lugar");
        JTextField txtLugar = new JTextField("");
        
        btnAgregar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(txtNombre.getText(), txtLugar.getText());
            }
        });
        
        btnRegresar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed();
            }
        });
        
        p1.add(lbNombre);
        p1.add(txtNombre);
        p1.add(lbLugar);
        p1.add(txtLugar);
        p2.add(btnRegresar);
        p2.add(btnAgregar);
                
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
    }
    
    private void btnAgregarActionPerformed(String in_nombre, String in_lugar)
    {
        /*
        Variable        Tipo        Uso
        in_nombre       String      Nombre que se recibe del campo de texto
                                    (txtNombre) en AgregarAutor().
        in_lugar        String      Nombre que se recibe del campo de texto
                                    (txtLugar) en AgregarAutor().
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
                if(ProyectoPOO.editoriales[i].get_disponible())
                {
                    ProyectoPOO.editoriales[i].put_nombre(in_nombre);
                    ProyectoPOO.editoriales[i].put_lugar(in_lugar);
                    ProyectoPOO.editoriales[i].put_disponible(false);
                    confirmar = true;
                }
                else
                {
                    i++;
                }
                
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
