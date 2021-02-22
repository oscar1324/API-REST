package com.kike.colegio.controladores.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.repositorios.AlumnoRepository;

@RestController
@RequestMapping("/v1")
public class AlumnoControllerR {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	// INSERTAR -------------------------------------------------------------------------------------------------------------------
	@PostMapping("/alumnos")
	public ResponseEntity<String> insertarAlumno (@RequestBody AlumnoEntity alumno){
		
		alumnoRepository.save(alumno);
		
		return new ResponseEntity<>("Inserción correcta", HttpStatus.OK);
		
	}
	
	// LISTAR -------------------------------------------------------------------------------------------------------------------
	// llamada en general
	@GetMapping(value = "/alumnos")
	public Iterable<AlumnoEntity> listarTodosAlumnos(){
		/* Si quiero obtener un alumno por id o algun otro parametro le introducto un @ReqeustParam y el campo*/
		return alumnoRepository.findAll();
	}
	// Llamada por id 
	@GetMapping(value = "/alumnos/{id}")
	public Optional<AlumnoEntity> listarTodosAlumnosiD(
			@RequestParam(value="id", required = false) Integer id){
		/* Si quiero obtener un alumno por id o algun otro parametro le introducto un @ReqeustParam y el campo*/
		return alumnoRepository.findById(id);
	}
	
	
	// Llamada por id + nombre
	@GetMapping(value = "/alumnos", params = { "id", "nombre"})
	public Iterable <AlumnoDTO> listarTodosAlumnosporIDyNombre(
			@RequestParam("id") Integer id,
			@RequestParam("nombre") String nombre){
		/* Si quiero obtener un alumno por id o algun otro parametro le introducto un @ReqeustParam y el campo*/
		return alumnoDAO.obtenerAlumnosporIdyNombre(id, nombre);
	}
	
	
	// ACTUALIZAR -------------------------------------------------------------------------------------------------------------------
	@PutMapping(value="/alumnos")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AlumnoEntity alumno){
		alumnoRepository.save(alumno);
		 return new ResponseEntity<> ("actualización correcta", HttpStatus.OK);
	}
	// BORRAR -------------------------------------------------------------------------------------------------------------------
	
	@DeleteMapping(value="/alumnos/{id}")
	public ResponseEntity<String> borrarAlumno(@PathVariable("id") Integer id){
		alumnoRepository.deleteById(id);
		 return new ResponseEntity<> ("Borrado correcta", HttpStatus.OK);
	}
}
