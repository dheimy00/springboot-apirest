package br.com.builders.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Size(min = 2 , message = "O primeiro nome deve ter pelo menos 2 caracteres")
	@Column(name = "nome",nullable = false)
	private String nome;
	
	@NotNull
	@Column(name = "cpf",nullable = false)
	@CPF(message = "CPF é inválido")
	private String cpf;
	
	@NotNull
	@Column(name = "dataNascimento",nullable = false)
	private Date dataNascimento;
	
	

}
