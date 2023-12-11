/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comal;

/**
 *
 * @author romai
 */
public class User {
    private int file;
    private String Name;
    private double credit; 

    public User(int file, double credit, String Name) {
        this.file = file;
        this.credit = credit;
        this.Name = Name;
    }

    public int getFile() {
        return file;
    }

    public String getName() {
        return Name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" + "file=" + file + ", Name=" + Name + ", credit=" + credit + '}';
    }   
    
}
