package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	@Query("Select c from Cart c where c.user.userId=:userId")
	List<Cart> findCartByUserId(@Param("userId") int userId);
}
