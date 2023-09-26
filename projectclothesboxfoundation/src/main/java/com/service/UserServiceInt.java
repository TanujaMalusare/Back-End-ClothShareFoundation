package com.service;

import java.io.IOException;
//import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.multipart.MultipartFile;

import com.model.Cart;
import com.model.Donar;
import com.model.Login;
import com.model.Product;
import com.model.User;

public interface UserServiceInt {
	public User addUser(User user);
	//Create Method on UserRepository
	public User getUserByEmail(String email);
	
	public User findByEmailIdAndPassword(String email ,String password);
	public User getUserById(int userId);
	
	
	public Product getProductById(int productId);


	public Product addProduct(Product product);
	
	
	public List<Product> getAllProducts();
	
	//Create Method on ProductRepository
//	public List<Product> getProductsByUserId(int id);
	
	public Product updateProduct(Product product);
	
	
	public void deleteProduct(int id);
	
	public Donar addDonar(Donar donar);
	public String uploadImage(MultipartFile image) throws IOException;
	
	
	
	public Cart addToCart(Cart cart);
	
	//Create Method on CartRepository
	public List<Cart> getFromCart(int userId);
	
	
	public void deleteCart(int id);

}
