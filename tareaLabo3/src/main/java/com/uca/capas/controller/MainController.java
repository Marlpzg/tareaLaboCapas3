package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0, "Botella de agua", 100));
		productos.add(new Product(1, "Leche", 30));
		productos.add(new Product(2, "Alcohol Gel", 2));
		productos.add(new Product(3, "Papel Higiénico", 0));
		productos.add(new Product(4, "Mascarilla", 1));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);

		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", productos.get(product.getId()).getNombre());
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad() && product.getCantidad() > 0) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}

}
