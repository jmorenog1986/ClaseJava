/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciar;

import co.edu.sena.controlador.PersonaControlador;
import co.edu.sena.vista.PersonaVista;

/**
 *
 * @author Jhon Moreno
 */
public class Inicio {
    public static void main(String[] args) {
        PersonaVista pv=new PersonaVista();
        PersonaControlador pc=new PersonaControlador(pv);
        pv.setVisible(true);
    }
}
