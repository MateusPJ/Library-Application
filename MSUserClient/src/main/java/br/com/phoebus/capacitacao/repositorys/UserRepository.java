package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.User;

/**
 * 
 * Repositório base utilizado para consultas em todos os serviços de usuário.
 * 
 * @author Mateus P Jorge
 *
 * @param <User> - Entidade genérica que recebe apenas User.
 * @param <Long> - Entidade genérica que recebe o tipo do id da entidade User(Long).
 */
public interface UserRepository extends JpaRepository<User, Long> {

}