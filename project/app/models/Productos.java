/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static jdk.nashorn.internal.runtime.Debug.id;
import play.data.Form;
import static play.data.Form.form;
import play.db.ebean.Model;
import play.db.ebean.*;
/**
 *
 * @author cristian
 */

@Entity
public class Productos extends Model {
  
    
 @Id  @GeneratedValue
 private long id;
 
 private String name;
 
 private String descripcion;
 
 @OneToMany(mappedBy="productos", cascade=CascadeType.ALL )
 private Set<Insumos> insumos;

    public Set<Insumos> getInsumos() {
        return insumos;
    }

    public void setInsumos(Set<Insumos> insumos) {
        this.insumos = insumos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
   
    public static List<Productos> all() {
    return new ArrayList<Productos>();
  }
    
    public static void create(Productos p) {
        p.save();
     }
    
     public static void update(Productos p) {
        p.update();
     }
     
     public static void delete(Productos p) {
        p.delete();
     }
    
    public static Finder<Integer, Productos> find = new Finder<Integer, Productos>(
        Integer.class, Productos.class);

    
}
