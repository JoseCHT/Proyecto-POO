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
public class ElegirLibro extends JFrame{
    public ElegirLibro()
    {
        /*
        Variable        Tipo            Uso
        p1              JPanel          Sirve como contenedor de los elementos.
        p2              JPanel          Sirve como contenedor de los elementos.
        bgAutores       ButtonGroup     Sirve para agrupar a los botones.
        btnCambiar      JButton         Sirve como el boton para confirmar la
                                        accion.
        */
        super("Proyecto 1.0");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel p1 = new JPanel(new GridLayout(0,5));
        JPanel p2 = new JPanel();
        
        ButtonGroup bgEditoriales = new ButtonGroup();
                
        for(int i=0; i<ProyectoPOO.libros.length;i++)
        {
            if(ProyectoPOO.libros[i].get_disponible())
                rdbLibros[i] = new JRadioButton("No existe");
            else
                rdbLibros[i] = new JRadioButton(ProyectoPOO.libros[i].get_titulo());    
            
            bgEditoriales.add(rdbLibros[i]);
            p1.add(rdbLibros[i]);
        }
        
        JButton btnCambiar = new JButton("Cambiar");
        
        btnCambiar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed();
            }
        });
        
        p2.add(btnCambiar);
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    private void btnCambiarActionPerformed()
    {
        /*
        Variable        Tipo        Uso
        i               int         Sirve como contador interno para el ciclo
                                    for.
        */
        for(int i=0; i<ProyectoPOO.libros.length;i++)
        {
            if(rdbLibros[i].isSelected() && !ProyectoPOO.libros[i].get_disponible())
                new CambiarLibro(i);
        }
        this.setVisible(false);
    }
    /*
    Variable        Tipo            Uso
    rdbAutores[]    JRadioButton    Son los botones para seleccionar al 
                                    autor.
    */
    private JRadioButton rdbLibros[] = new JRadioButton[ProyectoPOO.libros.length];
    
}
