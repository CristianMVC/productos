package controllers;


import java.util.List;
import models.Insumos;
import play.mvc.*;
import models.Productos;
import play.libs.Json;
import play.data.Form;
import static play.data.Form.form;

import views.html.*;


public class Application extends Controller {
    
static Form<Productos> taskForm = form(Productos.class); 
static Form<Insumos> taskForm2 = form(Insumos.class);
    public static Result index() {
        
      List<Productos> p = Productos.find.all();
              
        return ok(index.render(taskForm,p));
    }
    
    
    public static Result add()
    {
        Form<Productos> filledForm = taskForm.bindFromRequest();
        List<Productos> p = Productos.find.all();
        if(filledForm.hasErrors()) {
          return badRequest(index.render(taskForm,p));
        } else { 
        Productos.create(filledForm.get());
          return  redirect(routes.Application.index());  
        } 
    }

      public static Result modificar(long id)
      {
         int val =(int)id;
        Productos p = Productos.find.byId(val);
       
         return ok(modificar.render(taskForm,p));
      }
    
    public static Result mod(long id)
    {
     Form<Productos> filledForm = taskForm.bindFromRequest();   
     List<Productos> p = Productos.find.all();
      if(filledForm.hasErrors()) {
          return badRequest(index.render(taskForm,p));
        } else { 
         
          filledForm.get().setId(id);
          Productos.update(filledForm.get());
          return  redirect(routes.Application.index()); 
        } 
     
      
    }
      
    public static Result delete(long id)  
    {
      int val =(int)id;
      Productos p = Productos.find.byId(val);
      p.delete();
    
      return  redirect(routes.Application.index()); 
    }
      
   
    
    public static Result eliminar()
    {
       int id =Integer.parseInt(form().bindFromRequest().get("id"));
       Insumos in = Insumos.find.byId(id);
       in.delete();
    
     return  ok(Json.toJson(in)); 
    }
    
    public static Result agregar(long id)
    {
     int val =(int)id;
    
      return ok(insumos.render(val));
    }   
    
    public static Result addinsumo()
    {
      int id = Integer.parseInt(form().bindFromRequest().get("id"));
      String nombre = form().bindFromRequest().get("nombre");
      Productos p = Productos.find.byId(id);
      
      Insumos insumo = new Insumos();
      insumo.setNombre(nombre);
      insumo.setProductos(p);
      insumo.save();
      
      return  redirect(routes.Application.index()); 
    }
    
    
  
    
}