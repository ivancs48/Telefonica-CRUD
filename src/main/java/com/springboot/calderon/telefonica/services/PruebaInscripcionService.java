package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaInscripcion;
import com.springboot.calderon.telefonica.repositories.PruebaInscripcionRepository;

@Service
public class PruebaInscripcionService {

    @Autowired
    private PruebaInscripcionRepository repository;

    public List<PruebaInscripcion> findAll() {
        return repository.findAll();
    }

    public Optional<PruebaInscripcion> findById(int eid) {
        return repository.findById(eid);
    }

    public PruebaInscripcion save(PruebaInscripcion inscripcion) {
        return repository.save(inscripcion);
    }

    public void deleteById(int eid) {
        repository.deleteById(eid);
    }
}
