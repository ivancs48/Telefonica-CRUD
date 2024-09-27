package com.springboot.calderon.telefonica.services;

import java.util.List;

import com.springboot.calderon.telefonica.modelo.PruebaInscripcionDTO;

public interface PruebaInscripcionService {

    public List<PruebaInscripcionDTO> findAll();
    public PruebaInscripcionDTO findById(int eid);
    public PruebaInscripcionDTO save(PruebaInscripcionDTO inscripcion);
    public PruebaInscripcionDTO actualiza(PruebaInscripcionDTO inscripcion);
    public void deleteById(int eid);
}
