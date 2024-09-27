package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaEstudiante;
import com.springboot.calderon.telefonica.repositories.PruebaEstudianteRepository;

@Service
public class PruebaEstudianteService {

    @Autowired
    private PruebaEstudianteRepository repository;

    public List<PruebaEstudiante> findAll() {
        return repository.findAll();
    }

    public Optional<PruebaEstudiante> findById(int eid) {
        return repository.findById(eid);
    }

    public PruebaEstudiante save(PruebaEstudiante estudiante) {
        return repository.save(estudiante);
    }

    public void deleteById(int eid) {
        repository.deleteById(eid);
    }
}
