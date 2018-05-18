/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 *
 * @author cristian
 */

@Entity
public class Insumos extends Model {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   
 
@Id @GeneratedValue
private long id;

private String nombre;
    
    
 @ManyToOne
 private Productos productos;    

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
 
 
 public static Finder<Integer, Insumos> find = new Finder<Integer, Insumos>(
        Integer.class, Insumos.class);
 
  public static void delete(Insumos i) {
       i.delete();
     }
 
    
}

