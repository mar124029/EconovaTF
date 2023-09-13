package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	public Users findByUsername(String username);
}