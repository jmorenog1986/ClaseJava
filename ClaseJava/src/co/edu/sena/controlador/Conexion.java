/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.controlador;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jhon Moreno
 */
public class Conexion {
    Connection conexion;
    Statement stm;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/clasejava","root","");
            this.stm=this.conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrar(){
        try {
            this.conexion.close();
            this.stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    public ResultSet consultar(String sql){
        ResultSet r=null;
        try {
            r=stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    public boolean CUD(String sql){
        boolean b=false;
        try {
            b=stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            b=true;
        }
        return b;
    }

}
