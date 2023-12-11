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
public class Sales implements Iterable<OrderDish> {
    private int ids=1;
    private ArrayList<OrderDish>sales = new ArrayList<>();
    
    public void addSale(OrderDish order){
        ids++;
        sales.add(order);
    }
    public int lastId(){
        return ids;
    }

    public OrderDish getSale(int code){
	int size = sales.size();
	for(int indice = 0; indice<size; indice++) {
            OrderDish sale = sales.get(indice);
		if(sale.getId()==code) {
			return sale;
		}
	}
	return null;
    }

    @Override
    public Iterator<OrderDish> iterator() {
        return sales.iterator();
    }


}
