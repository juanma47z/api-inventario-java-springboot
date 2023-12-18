
package com.api.inventario.service;

import com.api.inventario.model.ProductoModel;
import com.api.inventario.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
  
  @Autowired
  IProductoRepository productoRepository;
  
  //Obtener todos los productos
  public ArrayList<ProductoModel> getProductos(){
    
    return (ArrayList<ProductoModel>) productoRepository.findAll();
  }
  
  //Guardar productos
  public ProductoModel saveProducto(ProductoModel producto){
    
    return productoRepository.save(producto);
  }
  
  //Obtener el producto por id
  public Optional<ProductoModel> getById(Long id){
    
    return productoRepository.findById(id);
  }
 
  //Modificar
  public ProductoModel updateProducto(ProductoModel request, Long id){
    
    ProductoModel producto = productoRepository.findById(id).get();
    
    producto.setNombre(request.getNombre());
    producto.setPrecio(request.getPrecio());
    producto.setCantidad(request.getCantidad());
    
    return producto;
    
  }
  
  //Eliminar
  public Boolean deleteProducto(Long id){
    try{
      productoRepository.deleteById(id);
      return true;
    }catch(Exception e){
      return false;
    } 
  }
}
