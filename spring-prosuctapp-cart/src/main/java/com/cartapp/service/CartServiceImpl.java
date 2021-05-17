package com.cartapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartapp.model.Product;

@Service
public class CartServiceImpl implements cartservice {
	@Autowired
	private RestTemplate restTemplate;
	private String baseURI = "http://PRODUCT-SERVICE/ProductService";
	List<Product> productlist;

	// private List<Product> productlist = new ArrayList<>();
	// mobilees/oneplus
//mobiiles/apple
	// laptops
	@Override
	public List<Product> addmanytocart(String category, String brand) {

		String URI = baseURI + "/productbycategory/" + category;
		//
		// List<Product> templist = new ArrayList<>();
		List<Product> response = restTemplate.getForObject(URI, List.class);
		productlist = response.stream().filter((i) -> i.getBrand().equals(brand) && i.getCategory().equals(category))
				.collect(Collectors.toList());
		System.out.println(productlist);
		return productlist;

		
		  for (LinkedHashMap<String, Object> productref : response) { Integer productId
		  = (Integer) productref.get("productId"); String name = (String)
		  productref.get("name"); String Brand = (String) productref.get("brand");
		  String Category = (String) productref.get("category"); Double price =
		  (Double) productref.get("price"); Product product = new Product(productId,
		  name, Brand, Category, price);
		  templist.add(product);
		 

	}}

	@Override
	public Product addonetocart(int productId) {

		productlist.clear();
		String url = baseURI + "/producproductsbyid/" + productId;
		Product product = restTemplate.getForObject(url, Product.class);
		productlist.add(product);

		return product;
	}

	@Override
	public List<Product> viewcart() {

		return productlist;
	}

}
