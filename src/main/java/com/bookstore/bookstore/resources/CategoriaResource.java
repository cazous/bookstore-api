package com.bookstore.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.model.entities.Categoria;
import com.bookstore.bookstore.service.CategoriaService;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
