package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.model.Product;
import com.model.User;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
	@ManyToOne
	@JoinColumn(name="productId", nullable=false)
	private Product product;
	
	@ManyToOne
    @JoinColumn(name="userId", nullable=false)
	private User user;
	
	
	public Cart() {
		super();
	}
	
	public Cart(int cartId, Product product, User user) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", user=" + user + "]";
	}
	
	

}
