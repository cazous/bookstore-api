package com.bookstore.bookstore.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O campo título é obrigatório")
	@Length(min = 3, max = 100, message = "O campo título deve ter entre 3 e 100 caracteres.")
	private String titulo;
	
	@NotEmpty(message = "O campo nome do autor é obrigatório")
	@Length(min = 3, max = 100, message = "O campo nome do autor deve ter entre 3 e 100 caracteres.")
	private String nome_autor;
	
	@NotEmpty(message = "O campo texto é obrigatório")
	@Length(min = 3, max = 2000000, message = "O campo texto deve ter entre 3 e 2000000 caracteres.")
	private String texto;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	Livro(){
		super();
	}
	
	public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the nome_autor
	 */
	public String getNome_autor() {
		return nome_autor;
	}

	/**
	 * @param nome_autor the nome_autor to set
	 */
	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
