package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaClase;
import com.springboot.calderon.telefonica.repositories.PruebaClaseRepository;

@Service
public class PruebaClaseService {

    @Autowired
    private PruebaClaseRepository repository;

    public List<PruebaClase> findAll() {
        return repository.findAll();
    }

    public Optional<PruebaClase> findById(int eid) {
        return repository.findById(eid);
    }

    public PruebaClase save(PruebaClase clase) {
        return repository.save(clase);
    }

    public void deleteById(int eid) {
        repository.deleteById(eid);
    }
}
