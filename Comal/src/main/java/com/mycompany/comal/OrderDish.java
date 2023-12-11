/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comal;

/**
 *
 * @author romai
 */
public class OrderDish {
    private int id;
    private Dishes dish;
    private int quantity;
    private double total;
    private int userId;
    
    public OrderDish(int id, Dishes dish, int quantity, int userId) {
        this.id = id;
        this.userId = userId;
        this.dish = dish;
        this.quantity = quantity;
        this.total = dish.getPrice()*quantity;
    }

    public int getId() {
        return id;
    }

    public Dishes getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "OrderDish{" + "id=" + id + ", dish=" + dish + ", quantity=" + quantity + ", total=" + total + '}';
    }  
    
}
