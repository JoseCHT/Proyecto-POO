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
public class CambiarEditorial extends JFrame {
    public CambiarEditorial(Editorial in_editorial)
    {
        /*
        Variable        Tipo        Uso
        p1              JPanel      Sirve como contenedor de los elementos.
        p2              JPanel      Sirve como contenedor de los elementos.
        lbNombre        JLabel      Sirve para identificar cada uno de los
                                    campos de Texto.
        txtNombre       JTextField  Sirve como el campo donde se introduce el
                                    nuevo nombre.
        btnAceptar      JButton     Sirve como el boton que confirma que la
                                    accion esta lista para realizarse.
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel(new GridLayout(0,2));
        JPanel p2 = new JPanel();
        
        JLabel lbNombre = new JLabel("Nombre");               
        JTextField txtNombre = new JTextField(in_editorial.get_nombre());
        JLabel lbLugar = new JLabel("Lugar");
        JTextField txtLugar = new JTextField(in_editorial.get_lugar());
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(in_editorial, txtNombre.getText());
            }
        });
        
        p1.add(lbNombre);
        p1.add(txtNombre);
        p1.add(lbLugar);
        p1.add(txtLugar);
        p2.add(btnAceptar);
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    private void btnAceptarActionPerformed(Editorial in_editorial, String in_nombre)
    {
        /*
        Variable        Tipo        Uso
        in_autor        Autor       Es el autor al que se le desea cambiar el
                                    nombre.
        in_nombre       String      Es el nuevo nombre que se le desea dar al
                                    objeto in_autor.
        */
        in_editorial.put_nombre(in_nombre);
        new ProyectoPOO();
        this.setVisible(false);
    }    
    
}
