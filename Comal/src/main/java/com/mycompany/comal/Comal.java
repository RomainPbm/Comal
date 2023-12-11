/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comal;
import java.util.Scanner;

public class Comal {
    Catalog catalog = new Catalog();
    Users users = new Users();
    Sales sales = new Sales();



    public Comal(){
                Dishes dish = new Dishes("1", "Torta de jamon" ,65, 3);
        catalog.addDishes(dish);
            Dishes dish2 = new Dishes("2", "Enchiladas" ,125, 2);
        catalog.addDishes(dish2);
            Dishes dish3 = new Dishes("3", "Quesadilla de bistec" ,35, 6);
        catalog.addDishes(dish3);

        User user = new User(1, 488, "Conde Contar");
        users.addUser(user);
        User user2 = new User(2, 1589, "Romain");
        users.addUser(user2);
        User user3 = new User(3, 3875, "Selena Gomez");
        users.addUser(user3);
        User user4 = new User(4, 165, "Terraneitor");
        users.addUser(user4);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Comal comal = new Comal();
        int opc1 = 1; 
        int opc2 = 1; 
        int opc3 = 1;
        int opc4 = 1;
        int file = 1;
        
        
        
        do{
        comal.menu1();
        opc1 = comal.getValidOption(0, 2, "Ingrese una opcion: ");
            switch(opc1){
                case 1:
                    
                    System.out.println("            ---COMAL---");
                    comal.displayCatalog();
                    String codeId=comal.getValidOptionString(1, 3, "Ingrese el id del platillo: ");
                    int cantidad=0;
                    while(cantidad==0){
                         System.out.println("Ingrese la cantidad de existencia nueva");
                         cantidad= Integer.parseInt(keyboard.nextLine());
                         if(cantidad<0){
                             System.out.println("Ingrese un numero mayor a 0");
                         }
                    }
                    comal.catalog.addDishQuantity(codeId, cantidad);
                break;
                case 2: //ingresar
                    comal.menu2();
                    opc2 = comal.getValidOption(1, 2, "Ingrese una opcion: ");
                    switch(opc2){
                        case 1: //alumno
                            System.out.print("\nIngrese su expediente: ");
                            file = Integer.parseInt(keyboard.nextLine());
                            comal.menu3();
                            opc3 = comal.getValidOption(1, 2, "Ingrese una opcion: ");
                            switch(opc3){
                                case 1: 
                                double credit=comal.menu4AddC();
                                comal.users.addCredit(file, credit);
                                
                                break;
                                case 2: comal.displayCatalog(); //ordenarestudiante
                                    String codeD = comal.getValidOptionString(1, 3, "Ingrese el id del platillo: ");
                                    int cantida = Integer.parseInt(keyboard.nextLine());                                  
                                    while(cantida == 0){
                                        System.out.println("Ingrese la cantidad de existencia nueva");
                                        cantidad= Integer.parseInt(keyboard.nextLine());
                                        if(cantidad < 0){
                                            System.out.println("Ingrese un numero mayor a 0");
                                        }
                                    }
                                    comal.checkPurchace(file, cantida, codeD);
                                    
                                break;
                            }
                        break;
                        case 2: //profesor
                            System.out.print("\nIngrese su expediente: ");
                            file = Integer.parseInt(keyboard.nextLine());
                            comal.menu3();
                            opc3 = comal.getValidOption(1, 2, "Ingrese una opcion: ");
                            switch(opc3){
                                case 1: comal.menu4AddC(); //creditoprofesor
                                break;
                                case 2: comal.displayCatalog(); //ordenarprofesor
                                String codeD = comal.getValidOptionString(1, 3, "Ingrese el id del platillo: ");
                                    int cantida = Integer.parseInt(keyboard.nextLine());                                  
                                    while(cantida == 0){
                                        System.out.println("Ingrese la cantidad del platillo");
                                        cantidad= Integer.parseInt(keyboard.nextLine());
                                        if(cantidad < 0){
                                            System.out.println("Ingrese un numero mayor a 0");
                                        }
                                    }
                                   if(comal.checkPurchace(file, cantida, codeD)){
                                       comal.sales.addSale(new OrderDish(comal.sales.lastId(),comal.catalog.getDish(codeD), cantida, file));
                                       comal.users.restarCredito((comal.catalog.getDish(codeD).getPrice()*cantida), file);
                                       comal.catalog.getDish(codeD).setQuantity((comal.catalog.getDish(codeD).getQuantity()-cantida));
                                   }
                                break;
                            }
                        break;    
                    }
                break;               
            }          
        }while (opc1 != 0);
        
        
        
    }
    
    public void menu1(){
        System.out.println("            ---COMAL---");
        System.out.println(" 1. Agregar existencia de un platillo");
        System.out.println(" 2. Iniciar sesion");
        System.out.println(" 0. Finalizar el dia");
    }
    
    public void menu2(){
        System.out.println("            ---COMAL---");
        System.out.println(" 1. Alumno");
        System.out.println(" 2. Profesor");   
    }
    
    public void menu3(){
        System.out.println("            ---COMAL---");
        System.out.println(" 1. Agregar credito");
        System.out.println(" 2. Ordenar un platillo"); 
    }
    
    public double menu4AddC(){     
        Scanner keyboard = new Scanner(System.in);
        double credit = 0;        
        boolean enterValid = false;
        
        System.out.println("            ---COMAL---");
        while (!enterValid) {
            System.out.print("Ingrese el credito que desea agregar: ");
            try {
                credit = Double.parseDouble(keyboard.nextLine());
                if ( credit > 0 ) {
                    enterValid = true;
                } else {
                    System.err.println("Error: Ingrese un numero mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un numero.");
            }     
        }
     
    return credit;
    }
        
    public void displayCatalog(){
        for(Dishes dish : catalog){
            System.out.println(dish.toString());
        }
    }
    
    public boolean checkPurchace(int file, int cantidad, String codeD){
        catalog.getDish(codeD).getQuantity();
        double total = (catalog.getDish(codeD).getPrice()*cantidad);
       
        boolean check = false;
        if(catalog.getDish(codeD).getQuantity() < cantidad){
        return false;
        }else{
            if(users.getUser(file).getCredit() < total ){
                return false;
            }
        }  
    return true;}
    
    public int getValidOption(int min, int max, String prompt) {
        Scanner keyboard = new Scanner(System.in);
        int option = -1;
        boolean enterValid = false;

        while (!enterValid) {
            try {
                System.out.print(prompt);
                option = Integer.parseInt(keyboard.nextLine());

                if (option >= min && option <= max) {
                    enterValid = true;
                } else {
                    System.err.println("Error: Ingrese una opción válida entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un número válido.");
            }
        }

        return option;
    }
    
    public String getValidOptionString(int min, int max, String prompt) {
        Scanner keyboard = new Scanner(System.in);
        String option = "";
        int id=0;
        boolean enterValid = false;

        while (!enterValid) {
            try {
                System.out.print(prompt);
                option = keyboard.nextLine();
                id=Integer.parseInt(option);
                if (id >= min && id <= max) {
                    enterValid = true;
                } else {
                    System.err.println("Error: Ingrese una opción válida entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un número válido.");
            }
        }

        return option;
    }
    
}
