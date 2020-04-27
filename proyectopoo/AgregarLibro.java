/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.*;
import java.awt.*;
import java.util.*;
        
/**
 *
 * @author rcgr
 */
public class AgregarLibro extends JFrame{
    public AgregarLibro()
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
        JPanel p2 = new JPanel(new GridLayout(1, 4));
        JPanel p3 = new JPanel();
        
        JButton btnAgregar = new JButton("Agregar");
        JButton btnRegresar = new JButton("Regresar");
        
        String nombresAutores[] = new String[ProyectoPOO.autores.length];
        String nombresEditoriales[] = new String[ProyectoPOO.editoriales.length];
        
        String dia[] = new String[31];
        String mes[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};;
        String anio[] = new String[621];
        
        for(int i=0;i<ProyectoPOO.autores.length;i++)
            nombresAutores[i]=ProyectoPOO.autores[i].get_nombre();
        
        for(int i=0;i<ProyectoPOO.editoriales.length;i++)
            nombresEditoriales[i]=ProyectoPOO.editoriales[i].get_nombre(); 
        
        for(int i=0;i<dia.length;i++)
            dia[i]=Integer.toString(i+1);
               
        for(int i=0;i<anio.length;i++)
            anio[i]=Integer.toString(2020-i);
        
        JLabel lbTitulo = new JLabel("Titulo");
        JTextField txtTitulo = new JTextField("");
        JLabel lbAutor = new JLabel("Autor");
        JComboBox cbAutor = new JComboBox(nombresAutores);
        JLabel lbEditorial = new JLabel("Editorial");
        JComboBox cbEditorial = new JComboBox(nombresEditoriales);
        JLabel lbPublicacion = new JLabel("Publicacion");
        JComboBox cbDia = new JComboBox(dia);
        JComboBox cbMes = new JComboBox(mes);
        JComboBox cbAnio = new JComboBox(anio);
                
        btnAgregar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(txtTitulo.getText(),cbAutor.getSelectedIndex(),cbEditorial.getSelectedIndex(), cbDia.getSelectedIndex()+1, cbMes.getSelectedIndex(), 2020-cbAnio.getSelectedIndex());
            }
        });
                
        btnRegresar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed();
            }
        });
        
        p1.add(lbTitulo);
        p1.add(txtTitulo);
        p1.add(lbAutor);
        p1.add(cbAutor);
        p1.add(lbEditorial);
        p1.add(cbEditorial);
        
        p2.add(lbPublicacion);
        p2.add(cbDia);
        p2.add(cbMes);
        p2.add(cbAnio);
        
        p3.add(btnRegresar);
        p3.add(btnAgregar);
                
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
    }
    
    private void btnAgregarActionPerformed(String in_titulo, int i_autor, int i_editorial, int dia, int mes, int anio)
    {
        /*
        Variable        Tipo        Uso
        in_titulo       String      Nombre que se recibe del campo de texto
                                    (txtTitulo) en AgregarLibro().
        in_autor        String      Nombre que se recibe del ComboBox
                                    (cbAutor) en AgregarLibro().
        in_editorial    String      Nombre que se recibe del ComboBox
                                    (cbEditorial) en AgregarLibro().
        in_dia          int         Entero que se recibe del ComboBox (cbDia)
                                    en AgregarLibro().
        in_mes          int         Entero que se recibe del ComboBox (cbMes)
                                    en AgregarLibro().
        in_anio         int         Entero que se recibe del ComboBox (cbAnio)
                                    en AgregarLibro().
        i               int         Saber en que posicion del arreglo 
                                    ProyectoPOO.autores[] va dentro del ciclo.
        confirmar       boolean     Saber si ya se asigno el nombre o no.
        */
        try
        {
            int i=0;
            boolean confirmar = true, verificado = true;
            
            for(int j=0;j<in_titulo.length();j++)
                if(in_titulo.charAt(j)=='$')
                    verificado = false;
            
            if(verificado)
            {
                while(confirmar)
                {   
                    if(ProyectoPOO.libros[i].get_disponible())
                    {
                        ProyectoPOO.libros[i].put_titulo(in_titulo);
                        ProyectoPOO.libros[i].put_autor(ProyectoPOO.autores[i_autor]);
                        ProyectoPOO.libros[i].put_editorial(ProyectoPOO.editoriales[i_editorial]);
                        ProyectoPOO.libros[i].put_publicacion(dia, mes, anio);
                        ProyectoPOO.libros[i].put_disponible(false);
                        confirmar = false;
                    }
                    else
                        i++;
                }
            }
            else
                JOptionPane.showMessageDialog(this, "El titulo contiene un caracter no valido.");
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
