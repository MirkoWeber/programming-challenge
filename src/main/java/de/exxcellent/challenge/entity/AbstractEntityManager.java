/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nabz32x
 * holds all standart entity Operations
 * @param <T> must be an extension of AbstractEntity
 */
public abstract class AbstractEntityManager<T extends AbstractEntity> {

    protected List<T> entities;
    
    public AbstractEntityManager(){
        this.entities = new ArrayList<>();
    }
    /**
     * 
     * @param id
     * @return T Object
     */
    public T findEntityById(String id) throws RuntimeException{
        for(T e : entities){
            if(e.getId().equals(id) )
                return e; 
        }
        return null;
    }
     /**
     * adds Entitiy c to Entitiy list entities.
     * @param  c entity which has to be added
    */
    public void addEntityFromObject(T c){
        if( findEntityById( c.getId() ) != null )
            throw new RuntimeException("Entity with the ID " + c.getId() + " allredy exist!"); 
        else entities.add(c);
        
    }
    /**
     * deletes the Entitiy with the given id
     * @param  id id of the Entitiy which has to be deleted
    */
    public void deleteEntity(String id){
        entities.remove(findEntityById(id)); 
    }

    
    /**
     * Cleans the List of Entities
     */
    public void clean(){
        entities.clear();
    }
    
    
    protected void replaceEntity(T entity){
        if(entities.contains(entity)){
            entities.remove(entity);
            entities.add(entity);
        }
    }
    public void setEntities(List<T> entities){
        this.entities = entities;
    }
    public List<T> getEntities(){
        return entities;
    }
    
    
    
    
    
    
}

    
