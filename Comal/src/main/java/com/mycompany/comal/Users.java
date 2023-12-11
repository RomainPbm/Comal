/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mau20
 */
public class Users implements Iterable<User> {
    private ArrayList<User>users = new ArrayList<>();
    
    public void addUser(User user){
        users.add(user);
    }
    
    public void restarCredito(double total, int file){
        this.getUser(file).setCredit((this.getUser(file).getCredit()-total));
    }
    
    public void addCredit(int code, double credit){
        this.getUser(code).setCredit((credit + this.getUser(code).getCredit()));
    }

    public User getUser(int code){
	int size = users.size();
	for(int indice = 0; indice<size; indice++) {
            User user = users.get(indice);
		if(user.getFile()==code) {
                    return user;
                }
	}
	return null;
    }

    
    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
    
        public int getSize(){
        return users.size();
    }
}


