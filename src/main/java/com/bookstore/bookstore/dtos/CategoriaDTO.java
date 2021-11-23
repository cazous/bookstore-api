package com.bookstore.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.bookstore.model.entities.Categoria;

public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty
	@Length(min = 3, max = 100, message = "O campo nome precisa ter entre 3 a 100 caracteres.")
	private String nome;
	@NotEmpty
	@Length(min = 3, max = 100, message = "O campo descrição precisa ter entre 3 a 100 caracteres.")
	private String descricao;
	
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
