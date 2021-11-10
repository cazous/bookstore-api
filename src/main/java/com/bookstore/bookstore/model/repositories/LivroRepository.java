package com.bookstore.bookstore.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.model.entities.Livro;

@Repository //Essa anotação não é necessária se a criação da classe já for feita como interface diretamente
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
