package com.idat.AlumnoPruebaIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.AlumnoPruebaIIE.model.Alumno;
import com.idat.AlumnoPruebaIIE.service.AlumnoService;

@Controller
@RequestMapping("/api/estudiante/v1")
public class EstudianteController {
	
	@Autowired
	private AlumnoService service;
	
	@GetMapping("/hola")
	public @ResponseBody String holaMundo() {
		return "Hola";
	}

	@GetMapping("/hola1")
	public ResponseEntity<String>  holaMundo1() {
		return new ResponseEntity<>( "Hola", HttpStatus.OK);
	}

	@GetMapping("/listar")
	public @ResponseBody List<Alumno> listar(){
		return service.listar();
	}
	
	
	@GetMapping("/listar/{id}")
	public @ResponseBody Alumno obtener(@PathVariable Integer id) {
		return service.obtenerId(id);
	}
	
	@PostMapping("/guardar")
	public  ResponseEntity<Void> guardar(@RequestBody Alumno alumno) {
		service.guardar(alumno);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody Alumno alumno) {
		service.actualizar(alumno);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
}

