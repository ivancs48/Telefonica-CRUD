package com.springboot.calderon.telefonica.services;

import java.util.List;

import com.springboot.calderon.telefonica.modelo.PruebaClaseDTO;

public interface PruebaClaseService {

	public List<PruebaClaseDTO> findAll();
	public PruebaClaseDTO findById(int eid);
	public PruebaClaseDTO save(PruebaClaseDTO pruebaClaseDto);
	public PruebaClaseDTO actualiza(PruebaClaseDTO pruebaClaseDto);
	public void deleteById(int eid);
	
}
