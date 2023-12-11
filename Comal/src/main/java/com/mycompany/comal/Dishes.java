/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comal;

/**
 *
 * @author romai
 */
public class Dishes {
    
    private String code;
    private String descripcion;
    private double price;
    private int quantity;

    public Dishes(String code, String descripcion, double price, int quantity) {
        this.code = code;
        this.descripcion = descripcion;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Dishes{" + "code=" + code + ", descripcion=" + descripcion + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
}
