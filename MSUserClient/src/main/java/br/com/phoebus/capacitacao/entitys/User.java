package br.com.phoebus.capacitacao.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Classe da API que representa um usuário.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NM_USER", nullable = false)
	private String name;

	@Column(name = "NR_AGE", nullable = false)
	private int age;

	@Column(name = "NM_PHONE",nullable = false)
	private String phone;

}