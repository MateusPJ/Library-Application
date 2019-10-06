
package br.com.phoebus.capacitacao.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Classe que representa um objeto para transferências de dados.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long id;

	private String name;

	private int age;

	private String phone;

}