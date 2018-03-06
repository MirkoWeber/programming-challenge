/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.entity;

import java.util.UUID;

/**
 *
 * @author Nabztastic
 */
public class AbstractEntity {
    protected String id;
    public AbstractEntity(){
        this.id = UUID.randomUUID().toString();
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
}
