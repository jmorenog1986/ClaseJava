/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.controlador;

import co.edu.sena.modelo.Persona;
import co.edu.sena.vista.PersonaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon Moreno
 */
public class PersonaControlador extends Persona implements ActionListener {

    private PersonaVista vista;

    public PersonaControlador(PersonaVista vista) {
        this.vista = vista;

        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);

        this.vista.btnActualizar.setActionCommand("Actualizar");
        this.vista.btnEliminar.setActionCommand("Eliminar");
        this.vista.btnConsultar.setActionCommand("Consultar");
        this.vista.btnGuardar.setActionCommand("Guardar");

    }

    public void crear() {
        Conexion c=new Conexion();
        String sql="INSERT INTO personas VALUES('"+getDocumento()+"','"+getNombre()+"','"+getApellido()+"','"+getEmail()+"')";
        msg(c.CUD(sql));
        c.cerrar();
    }

    public void eliminar() {
        Conexion c=new Conexion();
        String sql="DELETE FROM personas WHERE documento='"+getDocumento()+"'";
        msg(c.CUD(sql));
        c.cerrar();
    }

    public void actualizar() {
        Conexion c=new Conexion();
        String sql="UPDATE personas SET nombre='"+getNombre()+"', apellido='"+getApellido()+"', email='"+getEmail()+"' WHERE documento='"+getDocumento()+"'";
        msg(c.CUD(sql));
        c.cerrar();
    }
    
    public void msg(boolean b){
        if(!b){
            JOptionPane.showMessageDialog(this.vista, "Todo bien");
        }else{
            JOptionPane.showMessageDialog(this.vista, "Todo mal");
        }
    }

    public void consultar() {
        Conexion c=new Conexion();
        String sql="SELECT * FROM personas WHERE documento='"+getDocumento()+"'";
        ResultSet r=c.consultar(sql);
        try {
            while(r.next()){
                setDocumento(r.getInt(1));
                setNombre(r.getString(2));
                setApellido(r.getString(3));
                setEmail(r.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.cerrar();
        
        this.vista.txtApellido.setText(getApellido());
        this.vista.txtDocumento.setText(getDocumento()+"");
        this.vista.txtNombre.setText(getNombre());
        this.vista.txtEmail.setText(getEmail());
        
        
    }
    
    
     public void llenar(){
         int doc= Integer.parseInt(this.vista.txtDocumento.getText());
         
         
         setDocumento(doc);
         setNombre(this.vista.txtNombre.getText());
         setApellido(this.vista.txtApellido.getText());
         setEmail(this.vista.txtEmail.getText());
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        llenar();
        switch (e.getActionCommand()) {
            case "Actualizar":
                actualizar();
                break;
            case "Guardar":
                crear();
                break;
            case "Eliminar":
                eliminar();
                break;
            case "Consultar":
                consultar();
                break;
            default:
                throw new AssertionError();
        }

    }
}
