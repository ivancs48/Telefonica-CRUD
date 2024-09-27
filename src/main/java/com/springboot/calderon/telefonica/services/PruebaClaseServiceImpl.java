package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaClase;
import com.springboot.calderon.telefonica.modelo.PruebaClaseDTO;
import com.springboot.calderon.telefonica.repositories.PruebaClaseRepository;

@Service
public class PruebaClaseServiceImpl implements PruebaClaseService {

	@Autowired
	private PruebaClaseRepository repository;

	public List<PruebaClaseDTO> findAll() {
		List<PruebaClaseDTO> listado = repository.findAll().stream().map(PruebaClaseDTO::new)
				.collect(Collectors.toList());
		return listado;
	}

	public PruebaClaseDTO findById(int eid) {
		Optional<PruebaClase> pruebaClase = repository.findById(eid);
		PruebaClaseDTO pruebaClaseDTO = new PruebaClaseDTO();
		if (pruebaClase.isPresent()) {
			pruebaClaseDTO = new PruebaClaseDTO(pruebaClase.get());
		}
		return pruebaClaseDTO;
	}

	public PruebaClaseDTO save(PruebaClaseDTO pruebaClaseDto) {
		PruebaClase pruebaClase = repository.save(PruebaClaseDTO.pruebaClase2PruebaClaseDTO(pruebaClaseDto));
		PruebaClaseDTO pruebaClaseDTO = new PruebaClaseDTO(pruebaClase);
		return pruebaClaseDTO;
	}

	public PruebaClaseDTO actualiza(PruebaClaseDTO pruebaClaseDto) {
		Optional<PruebaClase> original = repository.findById(pruebaClaseDto.getEid());
		PruebaClaseDTO pruebaClaseDTO = new PruebaClaseDTO();
		if (original.isPresent()) {
			PruebaClase pruebaClase = repository.save(original.get());
			pruebaClaseDTO = new PruebaClaseDTO(pruebaClase);
		}
		return pruebaClaseDTO;
	}

	public void deleteById(int eid) {
		repository.deleteById(eid);
	}
}
