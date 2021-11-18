package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dtos.CategoriaDTO;
import com.bookstore.bookstore.model.entities.Categoria;
import com.bookstore.bookstore.model.repositories.CategoriaRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> object = categoriaRepository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null); //ID é definido como nulo por questões de segurança. Caso seja passado uma id já existente, o JPA vai entender como uma atualização e modificar as informações indevidamente.
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada. Possui livros associados.");
		}
	}
}
