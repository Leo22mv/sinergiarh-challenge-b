package sinergiarh.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sinergiarh.challenge.entity.Gender;
import sinergiarh.challenge.repository.GenderRepository;
import sinergiarh.challenge.service.GenderService;

// Implementación del servicio de géneros

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Long id) {
        if (!genderRepository.existsById(id)) {
            throw new RuntimeException("Genero con ID " + id + " no encontrado.");
        }
        return genderRepository.findById(id);
    }
    
}
