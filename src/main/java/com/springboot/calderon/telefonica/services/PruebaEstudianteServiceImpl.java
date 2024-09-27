package com.springboot.calderon.telefonica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.calderon.telefonica.entities.PruebaEstudiante;
import com.springboot.calderon.telefonica.modelo.PruebaEstudianteDTO;
import com.springboot.calderon.telefonica.repositories.PruebaEstudianteRepository;

@Service
public class PruebaEstudianteServiceImpl implements PruebaEstudianteService {

	@Autowired
	private PruebaEstudianteRepository repository;

	@Override
	public List<PruebaEstudianteDTO> findAll() {
		List<PruebaEstudianteDTO> listado = repository.findAll().stream().map(PruebaEstudianteDTO::new)
				.collect(Collectors.toList());
		return listado;
	}

	@Override
	public PruebaEstudianteDTO findById(int eid) {
		Optional<PruebaEstudiante> pruebaClase = repository.findById(eid);
		PruebaEstudianteDTO pruebaClaseDTO = new PruebaEstudianteDTO();
		if (pruebaClase.isPresent()) {
			pruebaClaseDTO = new PruebaEstudianteDTO(pruebaClase.get());
		}
		return pruebaClaseDTO;
	}

	@Override
	public PruebaEstudianteDTO save(PruebaEstudianteDTO estudiante) {
		PruebaEstudiante pruebaClase = repository
				.save(PruebaEstudianteDTO.PruebaEstudiante2PruebaEstudianteDTO(estudiante));
		PruebaEstudianteDTO pruebaClaseDTO = new PruebaEstudianteDTO(pruebaClase);
		return pruebaClaseDTO;
	}

	@Override
	public PruebaEstudianteDTO actualiza(PruebaEstudianteDTO estudiante) {
		Optional<PruebaEstudiante> original = repository.findById(estudiante.getEid());
		PruebaEstudianteDTO pruebaEstudianteDTO = new PruebaEstudianteDTO();
		if (original.isPresent()) {
			PruebaEstudiante pruebaEstudiante = original.get();
			pruebaEstudiante.setEid(estudiante.getEid());
			pruebaEstudiante.setNombre(estudiante.getNombre());
			pruebaEstudiante.setEspecialidad(estudiante.getEspecialidad());
			pruebaEstudiante.setGrado(estudiante.getGrado());

			PruebaEstudiante updatedEstudiante = repository.save(pruebaEstudiante);
			pruebaEstudianteDTO = new PruebaEstudianteDTO(updatedEstudiante);
		}
		return pruebaEstudianteDTO;
	}

	@Override
	public void deleteById(int eid) {
		repository.deleteById(eid);
	}

}
