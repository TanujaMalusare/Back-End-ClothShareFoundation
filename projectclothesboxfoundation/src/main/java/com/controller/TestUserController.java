package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Cart;
import com.model.Donar;
import com.model.Login;
import com.model.Product;
import com.model.User;
import com.service.UserServiceImpl;
import com.service.UserServiceInt;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("cbf")
public class TestUserController {
	private byte[] bytes;
	@Autowired
	UserServiceInt userService;
	
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws Exception
	{
		String tempEmail =user.getEmail();
		if(tempEmail !=null && !"".equals(tempEmail)) {
			User userObj=userService.getUserByEmail(tempEmail);
			if(userObj!=null) {
				throw new Exception("User with "+tempEmail+" is already exit");
			}
		}
		User userObj1=null;
		userObj1=userService.addUser(user);
		return userObj1;
	}
	@PostMapping("/loginUser")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPass=user.getPassword();
		User userObj=null;
		if(tempEmail !=null && tempPass!=null) {
			userObj=userService.findByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad Creadentials");
		}
		return userObj;
		
	}
	
	@GetMapping("/getUser/{id}")
	ResponseEntity<User> getUser(@PathVariable("id") int id)
	{
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{id}")
	ResponseEntity<Product> getProduct(@PathVariable("id") int id)
	{
		Product product = userService.getProductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	ResponseEntity<User> getUserByEmail(@PathVariable("email") String email)
	{
		User user = userService.getUserByEmail(email);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/adddonar")
	public void createDoanr(@RequestBody Donar donar) throws IOException {
		donar.setPicByte(this.bytes);
		userService.addDonar(donar);
		this.bytes = null;
	}
	
		
	@PutMapping(value="/updateProduct")
	ResponseEntity<?> updateProduct(@RequestBody Product product) throws IOException
	{
		Product product1 = new Product();
		product1 = userService.updateProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllProducts")
	ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products = userService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
//	@GetMapping("/getProductsByUser/{id}")
//	ResponseEntity<List<Product>> getProductsByUser(@PathVariable("id") int id)
//	{
//		List<Product> products = userService.getProductsByUserId(id);
//		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
//	}
	
	@PostMapping("/addToCart")
	Cart addCart(@RequestBody Cart cart)
	{
		return userService.addToCart(cart);
	}
	
	@GetMapping("/getCartByUser/{id}")
	ResponseEntity<List<Cart>> getCartByUser(@PathVariable("id") int id)
	{
		List<Cart> carts = userService.getFromCart(id);
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	void deleteCart(@PathVariable("id") int id)
	{
		userService.deleteCart(id);
	}

}
 