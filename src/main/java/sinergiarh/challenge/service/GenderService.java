package sinergiarh.challenge.service;

import java.util.List;
import java.util.Optional;

import sinergiarh.challenge.entity.Gender;

// Interfaz para el servicio de géneros

public interface GenderService {
    List<Gender> findAll();
    Optional<Gender> findById(Long id);
}