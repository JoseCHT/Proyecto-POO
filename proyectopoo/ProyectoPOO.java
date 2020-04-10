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
public class ProyectoPOO extends JFrame {

    /**
     * @param args the command line arguments
     */
        public static Libro libros[] = new Libro[10];        
        public static Autor autores[] = new Autor[10];
        public static Editorial editoriales[] = new Editorial[10];
        
    public static void main(String[] args) {
    // TODO code application logic here
        /*
        Variable    Tipo        Usos
        libros      Libro       Almacena los n objetos de tipo Libro.        
        */
                
        for(int i=0;i<libros.length;i++)
            libros[i] = new Libro();
               
        for(int i=0;i<autores.length;i++)
            autores[i] = new Autor();
        
        for(int i=0;i<editoriales.length;i++)
            editoriales[i] = new Editorial();
        
        new ProyectoPOO();

    }
    
    public ProyectoPOO()
    {
        /*
        Variable        Tipo        Uso
        btnEditoriales  JButton     Sirve como el boton de las Editoriales.
        btnAutores      JButton     Sirve como el boton de los Autores.
        btnLibros       JButton     Sirve como el boton de los Libros.
        btnPersonas     JButton     Sirve como el boton de las Personas.
        btnPrestamos    JButton     Sirve como el boton de los Prestamos.
        p1              JPanel      Es uno de los contenedores de los elementos.
        p2              JPanel      Es uno de los contenedores de los elementos.
        */
        super("Proyecto 1.0");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        /*
        Se hacen los paneles donde iran los componentes de la ventana 
        ProyectoPOO
        */
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new GridLayout(0, 1));
        
        JButton btnEditoriales = new JButton("Editoriales");
        /*
        Se agrega un ActionListener al boton btnEditoriales.
        */
        btnEditoriales.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt1) {
                btnsActionPerformed(0);
            }
        });
        
        JButton btnAutores = new JButton("Autores");
        /*
        Se agrega un ActionListener al boton btnAutores.
        */
        btnAutores.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt2) {
                btnsActionPerformed(1);
            }
        });
        
        JButton btnLibros = new JButton("Libros");
        /*
        Se agrega un ActionListener al boton btnLibros.
        */
        btnLibros.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt3) {
                btnsActionPerformed(2);
            }
        });
        
        JButton btnPersonas = new JButton("Personas");
        /*
        Se agrega un ActionListener al boton btnPersonas.
        */
        btnPersonas.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt4) {
                btnsActionPerformed(3);
            }
        });
        
        JButton btnPrestamos = new JButton("Prestamos");
        /*
        Se agrega un ActionListener al boton btnPrestamos.
        */
        btnPrestamos.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt5) {
                btnsActionPerformed(4);
            }
        });
        /*
        Se agregan los componentes a cada panel.
        */
        p2.add(btnEditoriales);
        p2.add(btnAutores);
        p2.add(btnLibros);
        p2.add(btnPersonas);
        p2.add(btnPrestamos);
        /*
        Y los paneles se agregan a la ventana ProyectoPOO.
        */
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        pack();
        setVisible(true); 
    }
    
    private void btnsActionPerformed(int op)
    {
        /*
        Esta es la accion que se llevara acabo cuando ocurra alguno de los
        que verifica el ActionListener.
        */
        new VentanaAcciones(op);
        this.setVisible(false);
    }
}
