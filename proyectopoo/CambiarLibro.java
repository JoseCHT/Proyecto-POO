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
public class CambiarLibro extends JFrame{
    public CambiarLibro(int id_libro)
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
        
        int j=0, k=0, l=0, d=0, m=0, a=0;
        
        JPanel p1 = new JPanel(new GridLayout(0,2));
        JPanel p2 = new JPanel(new GridLayout(0,4));
        JPanel p3 = new JPanel();
        
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
        
        while(ProyectoPOO.libros[id_libro].get_autor().get_nombre().compareTo(ProyectoPOO.autores[j].get_nombre())!=0)
            j++;
        
        while(ProyectoPOO.libros[id_libro].get_editorial().get_nombre().compareTo(ProyectoPOO.editoriales[k].get_nombre())!=0)
            k++;
        
        while(ProyectoPOO.libros[id_libro].get_publicacion().get(Calendar.DAY_OF_MONTH)!=Integer.parseInt(dia[d]))
            d++;
        
        while(ProyectoPOO.libros[id_libro].get_publicacion().get(Calendar.MONTH)!=m)
            m++;
                
        while(ProyectoPOO.libros[id_libro].get_publicacion().get(Calendar.YEAR)!=Integer.parseInt(anio[a]))
            a++;
        
        JLabel lbTitulo = new JLabel("Titulo");
        JTextField txtTitulo = new JTextField(ProyectoPOO.libros[id_libro].get_titulo());
        JLabel lbAutor = new JLabel("Autor");
        JComboBox cbAutor = new JComboBox(nombresAutores);
        cbAutor.setSelectedIndex(j);
        
        JLabel lbEditorial = new JLabel("Editorial");
        JComboBox cbEditorial = new JComboBox(nombresEditoriales);
        cbEditorial.setSelectedIndex(k);
        
        JLabel lbPublicacion = new JLabel("Publicacion");
        JComboBox cbDia = new JComboBox(dia);
        cbDia.setSelectedIndex(d);
        
        JComboBox cbMes = new JComboBox(mes);
        cbMes.setSelectedIndex(m);
        
        JComboBox cbAnio = new JComboBox(anio);
        cbAnio.setSelectedIndex(a);
                       
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(ProyectoPOO.libros[id_libro], txtTitulo.getText());
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
        
        p3.add(btnAceptar);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    private void btnAceptarActionPerformed(Libro in_libro, String in_nombre)
    {
        /*
        Variable        Tipo        Uso
        in_autor        Autor       Es el autor al que se le desea cambiar el
                                    nombre.
        in_nombre       String      Es el nuevo nombre que se le desea dar al
                                    objeto in_autor.
        */
        new ProyectoPOO();
        this.setVisible(false);
    }    
}
