/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yossargueta.hellopmp202103.dulcestela;
import com.yossargueta.hellopmp202103.utilidades.Layout;
import java.util.Scanner;

/**
 *
 * @author Christian Midence
 */
public class Main {
      public static void main (String[] args) {
        Layout.printHeader("Curso de Cocina ");
        String OpcionMenu = "";
        
        Scanner entradaTeclado = new Scanner(System.in);
        
        Aplicacion cursoApp = new Aplicacion(entradaTeclado);
        
        while (!(OpcionMenu.toUpperCase().equals("S"))) {
            Layout.printMenu();
            OpcionMenu = entradaTeclado.nextLine();

            System.out.println("Texto ingresado es igual a " + OpcionMenu);
            // Verificar las Opciones
            cursoApp.activarEvento(OpcionMenu);
            
        }
     }
}
