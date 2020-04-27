/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ProyectoPOO extends JFrame{

    /**
     * @param args the command line arguments
     */
        public static File fileLibros = new File("src/libros.txt");
        public static File fileAutores = new File("src/autores.txt");
        public static File fileEditoriales = new File("src/editoriales.txt");
                
        public static Libro libros[] = new Libro[10];        
        public static Autor autores[] = new Autor[10];
        public static Editorial editoriales[] = new Editorial[10];
        
    public static void main(String[] args) {
    // TODO code application logic here
        /*
        Variable       Tipo         Usos
        libros         Libro        Almacena los n objetos de tipo Libro.    
        autores        Autor        Almacena los n objetos de tipo Autor. 
        editoriales    Editorial    Almacena los n objetos de tipo Editorial.
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
        btnGuardar      JButton     Sirve para guardar todos los datos en
                                    archivos de texto.
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
        btnEditoriales.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16)); //Cambiar estilo
        
        JButton btnAutores = new JButton("Autores");
        /*
        Se agrega un ActionListener al boton btnAutores.
        */
        btnAutores.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt2) {
                btnsActionPerformed(1);
            }
        });
        btnAutores.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16)); //Cambiar estilo
        
        JButton btnLibros = new JButton("Libros");
        /*
        Se agrega un ActionListener al boton btnLibros.
        */
        btnLibros.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt3) {
                btnsActionPerformed(2);
            }
        });
        btnLibros.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16)); //Cambiar estilo
        
        JButton btnPersonas = new JButton("Personas");
        /*
        Se agrega un ActionListener al boton btnPersonas.
        */
        btnPersonas.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt4) {
                btnsActionPerformed(3);
            }
        });
        btnPersonas.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16)); //Cambiar estilo
        
        JButton btnPrestamos = new JButton("Préstamos");
        /*
        Se agrega un ActionListener al boton btnPrestamos.
        */
        btnPrestamos.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt5) {
                btnsActionPerformed(4);
            }
        });
        btnPrestamos.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16));
        
        
        JButton btnGuardar = new JButton("Guardar");
        /*
        Se agrega un ActionListener al boton btnGuardar.
        */
        btnGuardar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt5) {
                btnGuardarActionPerformed();
            }
        });
        btnGuardar.setFont(new Font("Segoe UI Semibold",Font.ITALIC,16));
        
        /*
        Se agregan los componentes a cada panel.
        */
        p2.add(btnEditoriales);
        p2.add(btnAutores);
        p2.add(btnLibros);
        p2.add(btnPersonas);
        p2.add(btnPrestamos);
        p2.add(btnGuardar);
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
    
    private void btnGuardarActionPerformed()
    {
        /*
        Esta es la accion que se lleva acabo cuando se decide guardar
        */
        try
        {   
            FileWriter wLibros = new FileWriter(fileLibros);
            FileWriter wAutores = new FileWriter(fileAutores);
            FileWriter wEditoriales = new FileWriter(fileEditoriales);
            
            for(int i=0;i<libros.length;i++)
            {
                if(libros[i].get_titulo()!="")
                    wLibros.write(i+"$"+libros[i].get_titulo()+
                                "$"+libros[i].get_editorial().get_nombre()+
                                "$"+libros[i].get_autor().get_nombre()+
                                "$"+libros[i].get_publicacion().get(Calendar.DAY_OF_MONTH)+
                                "$"+libros[i].get_publicacion().get(Calendar.MONTH)+
                                "$"+libros[i].get_publicacion().get(Calendar.YEAR)+"\n");
            }
            
            for(int i=0;i<autores.length;i++)
            {
                if(autores[i].get_nombre()!="")
                    wAutores.write(i+"$"+autores[i].get_nombre()+"\n");
            }
            
            for(int i=0;i<editoriales.length;i++)
            {
                if(editoriales[i].get_nombre()!="")
                    wEditoriales.write(i+"$"+editoriales[i].get_nombre()+
                            "$"+editoriales[i].get_lugar()+"\n");
            }
            
            wLibros.close();
            wAutores.close();
            wEditoriales.close();
        } catch(IOException e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(this,"Se ha guardado exitosamente.");
    }
}