
package com.api.inventario.controllers;

import com.api.inventario.model.ProductoModel;
import com.api.inventario.service.ProductoService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {
  
  @Autowired
  private ProductoService productoService;
  
  @GetMapping
  public ArrayList<ProductoModel> getProductos(){
    
    return this.productoService.getProductos();
  }
  
  @PostMapping
  public ProductoModel saveProducto(@RequestBody ProductoModel producto){
    
    return this.productoService.saveProducto(producto);
  }
  
  @GetMapping(path = "/{id}")
  public Optional<ProductoModel> getProductoById(@PathVariable Long id){
    
    return this.productoService.getById(id);
  }
  
  @PutMapping(path = "/{id}")
  public ProductoModel updateProductoById(@RequestBody ProductoModel request,@PathVariable("id") Long id){
    
    return this.productoService.updateProducto(request, id);
  }
  
  @DeleteMapping(path = "/{id}")
  public String deleteProductoById(@PathVariable ("id") Long id){
    
    boolean confirmacion = this.productoService.deleteProducto(id);
    
    if(confirmacion){
      return "Producto con id " + id + " eliminado";
    }else{
      
      return "Error, problema al eliminar el producto con el id " + id;
    }
    
  }
  
}
