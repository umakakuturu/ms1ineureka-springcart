package com.cartapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartapp.model.Product;

@Service
public interface cartservice {
	public List<Product> addmanytocart(String category, String brand);

	public Product addonetocart(int productId);

	public List<Product> viewcart();

}
