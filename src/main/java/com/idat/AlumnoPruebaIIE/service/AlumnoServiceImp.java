package com.idat.AlumnoPruebaIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AlumnoPruebaIIE.model.Alumno;
import com.idat.AlumnoPruebaIIE.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	public List<Alumno> listar() {
		return repository.findAll();
	}

	@Override
	public Alumno obtenerId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		repository.save(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(alumno);
	}

}
