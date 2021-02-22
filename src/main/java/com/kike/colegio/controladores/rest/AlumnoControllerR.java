package com.kike.colegio.controladores.rest;

import java.util.List;
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
	@GetMapping(value="/alumnos")
	public Iterable<AlumnoEntity> listaTodosAlumnos(){
		return alumnoRepository.findAll();
		
	}
	@GetMapping(value="/alumnos/{id}")
	public Optional<AlumnoEntity> buscarAlumnoPorId(@PathVariable("id") Integer id){
		return alumnoRepository.findById(id);
	}
	
	@GetMapping(value="/alumnos/",params= {"id","nombre"})
	public List<AlumnoDTO> listarAlumnosPorIdNombre(
			@RequestParam("id")Integer id,
			@RequestParam("nombre")String nombre){
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
