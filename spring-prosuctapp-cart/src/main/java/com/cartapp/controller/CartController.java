package com.cartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartapp.model.Product;
import com.cartapp.service.cartservice;

@RestController
@RequestMapping("/cartservice")
public class CartController {

	@Autowired
	cartservice Cartservice;

//cartservice/addonetocart/1
	@GetMapping("/addmanytocart/{category}/{brand}")

	public List<Product> addmanytocart(@PathVariable("category") String category, @PathVariable("brand") String brand) {
		return Cartservice.addmanytocart(category, brand);

	}

	@GetMapping("/addonetocart/{productid}")
	public Product addonetocart(@PathVariable("productid") int productid) {

		return Cartservice.addonetocart(productid);
	}

	@GetMapping("/viewcart")
	public List<Product> viewcart() {
		return Cartservice.viewcart();
	}

}
