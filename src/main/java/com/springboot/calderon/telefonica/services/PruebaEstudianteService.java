package com.springboot.calderon.telefonica.services;

import java.util.List;

import com.springboot.calderon.telefonica.modelo.PruebaEstudianteDTO;

public interface PruebaEstudianteService {

    public List<PruebaEstudianteDTO> findAll();
    public PruebaEstudianteDTO findById(int eid);
    public PruebaEstudianteDTO save(PruebaEstudianteDTO estudiante);
    public PruebaEstudianteDTO actualiza(PruebaEstudianteDTO estudiante);
    public void deleteById(int eid);
    
}
