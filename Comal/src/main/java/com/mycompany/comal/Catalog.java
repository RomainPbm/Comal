/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author romai
 */
public class Catalog implements Iterable<Dishes> {
    
    private ArrayList<Dishes>dishes = new ArrayList<>();
    
    public void addDishes(Dishes dish){
        dishes.add(dish);
    }
    
    //Se crea una funcion para tener la cantidad de platillos y agregar
    public void addDishQuantity(String id, int cantidad){
          for (Dishes dish : dishes) {
            if (dish.getCode().equals(id)) {
                dish.setQuantity((dish.getQuantity()+cantidad));
                break;
            }
        }
    }
    
    
    public Dishes getDish(String code){
	int size = dishes.size();
	for(int indice = 0; indice<size; indice++) {
            Dishes dish = dishes.get(indice);
		if(dish.getCode().equals(code)) {
			return dish;
		}
	}
	return null;
    }


    
    @Override
    public Iterator<Dishes> iterator() {
      return dishes.iterator();
    }
}