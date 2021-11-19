package com.bookstore.bookstore.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.model.entities.Livro;

@Repository //Essa anotação não é necessária se a criação da classe já for feita como interface diretamente
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
	
}
