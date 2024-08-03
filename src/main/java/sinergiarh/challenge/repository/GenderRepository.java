package sinergiarh.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinergiarh.challenge.entity.Gender;

// Repositorio que brinda los métodos necesarios para administrar los géneros

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
