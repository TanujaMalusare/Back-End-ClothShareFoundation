package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
//	@Query("Select p from Product p where p.user.userId=:userId")
//	List<Product> findProductByUserId(@Param("userId") int userId);
//	

}
