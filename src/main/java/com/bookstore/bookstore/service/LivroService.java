package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.model.entities.Categoria;
import com.bookstore.bookstore.model.entities.Livro;
import com.bookstore.bookstore.model.repositories.LivroRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> object = livroRepository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		
		return livroRepository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		livroRepository.delete(obj);
	}
	
	
}
