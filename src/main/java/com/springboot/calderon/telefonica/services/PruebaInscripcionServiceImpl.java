package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaEstudiante;
import com.springboot.calderon.telefonica.entities.PruebaInscripcion;
import com.springboot.calderon.telefonica.modelo.PruebaEstudianteDTO;
import com.springboot.calderon.telefonica.modelo.PruebaInscripcionDTO;
import com.springboot.calderon.telefonica.repositories.PruebaInscripcionRepository;

@Service
public class PruebaInscripcionServiceImpl implements PruebaInscripcionService {

    @Autowired
    private PruebaInscripcionRepository repository;

	@Override
	public List<PruebaInscripcionDTO> findAll() {
		List<PruebaInscripcionDTO> listado = repository.findAll().stream().map(PruebaInscripcionDTO::new)
				.collect(Collectors.toList());
		return listado;
	}

	@Override
	public PruebaInscripcionDTO findById(int eid) {
		Optional<PruebaInscripcion> pruebaClase = repository.findById(eid);
		PruebaInscripcionDTO pruebaClaseDTO = new PruebaInscripcionDTO();
		if (pruebaClase.isPresent()) {
			pruebaClaseDTO = new PruebaInscripcionDTO(pruebaClase.get());
		}
		return pruebaClaseDTO;
	}

	@Override
	public PruebaInscripcionDTO save(PruebaInscripcionDTO inscripcion) {
		PruebaInscripcion pruebaClase = repository
				.save(PruebaInscripcionDTO.PruebaInscripcion2PruebaInscripcionDTO(inscripcion));
		PruebaInscripcionDTO pruebaClaseDTO = new PruebaInscripcionDTO(pruebaClase);
		return pruebaClaseDTO;
	}

	@Override
	public PruebaInscripcionDTO actualiza(PruebaInscripcionDTO inscripcion) {
		Optional<PruebaInscripcion> original = repository.findById(inscripcion.getEid());
		PruebaInscripcionDTO pruebaEstudianteDTO = new PruebaInscripcionDTO();
		if (original.isPresent()) {
			PruebaInscripcion pruebaInscripcion = original.get();
			pruebaInscripcion.setEid(inscripcion.getEid());
			pruebaInscripcion.setNombreClase(inscripcion.getNombreClase());
			pruebaInscripcion.setPosicion(inscripcion.getPosicion());

			PruebaInscripcion updatedInscripcion = repository.save(pruebaInscripcion);
			pruebaEstudianteDTO = new PruebaInscripcionDTO(updatedInscripcion);
		}
		return pruebaEstudianteDTO;
	}

	@Override
	public void deleteById(int eid) {
		repository.deleteById(eid);
	}

	
}
