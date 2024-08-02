package sinergiarh.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sinergiarh.challenge.entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
