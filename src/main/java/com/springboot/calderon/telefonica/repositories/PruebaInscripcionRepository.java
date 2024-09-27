package com.springboot.calderon.telefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.calderon.telefonica.entities.PruebaInscripcion;

@Repository
public interface PruebaInscripcionRepository extends JpaRepository<PruebaInscripcion, Integer> {
 
}
