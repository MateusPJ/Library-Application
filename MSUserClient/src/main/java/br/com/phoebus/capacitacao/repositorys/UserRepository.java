package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.User;

/**
 * 
 * Reposit�rio base utilizado para consultas em todos os servi�os de usu�rio.
 * 
 * @author Mateus P Jorge
 *
 * @param <User> - Entidade gen�rica que recebe apenas User.
 * @param <Long> - Entidade gen�rica que recebe o tipo do id da entidade User(Long).
 */
public interface UserRepository extends JpaRepository<User, Long> {

}