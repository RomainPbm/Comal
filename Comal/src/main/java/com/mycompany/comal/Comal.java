/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comal;
import java.util.Scanner;

public class Comal {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        Comal comal = new Comal();
        int opc1 = 1; 
        int opc2 = 1;       
        boolean enterValid = false;
        
        
        comal.menu1();
        while (!enterValid) {
            System.out.print("Ingrese una opcion: ");
            try {
                opc1 = Integer.parseInt(keyboard.nextLine());
                if ( opc1 >= 0 && opc1 <= 2) {
                    enterValid = true;
                } else {
                    System.err.println("Error: Ingrese una valor de las opciones.");
                            
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un numero.");
            }     
        }
        
        do{
            switch(opc1){
                case 1: 
                    break;
                case 2:
                    comal.menu2();
                    while (!enterValid) {
                        System.out.print("Ingrese una opcion: ");
                        try {
                            opc2 = Integer.parseInt(keyboard.nextLine());
                            if ( opc2 == 1 && opc2 == 2) {
                                enterValid = true;
                            } else {
                                 System.err.println("Error: Ingrese una opcion");
                            }
                        } catch (NumberFormatException e) {
                             System.err.println("Error: Ingrese un numero.");
                        }     
                    }       
                    switch(opc2){
                        case 1:
                    
                    }
                break;
                
            }          
        }while (opc1 != 0);
        
        System.out.println("Ingreso 0 ");
        
        
    }
    
    public void menu1(){
        System.out.println("            ---COMAL---");
        System.out.println(" 1. Agregar un platillo al catalogo");
        System.out.println(" 2. Ordenar un platillo");
        System.out.println(" 0. Finalizar el dia");
    }
    
    public void menu2(){
        System.out.println("            ---COMAL---");
        System.out.println(" 1. Alumno");
        System.out.println(" 2. Profesor");   
    }
    
}
