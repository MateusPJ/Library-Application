package br.com.phoebus.capacitacao.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean findByName(String name);

}