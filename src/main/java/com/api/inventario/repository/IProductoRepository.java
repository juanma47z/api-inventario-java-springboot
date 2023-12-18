
package com.api.inventario.repository;

import com.api.inventario.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoModel, Long>{
  
}
