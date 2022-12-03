package com.rachel.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rachel.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	// make JPQL query for updating product stock
		@Modifying
		@Transactional
		@Query("update Product set stock=stock-:quantity where productId=:id")
		int updateProductStock(@Param("quantity") int quantity, @Param("id") int id);
		

}
