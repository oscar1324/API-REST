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

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.repositorios.AlumnoRepository;
import com.kike.colegio.repositorios.AsignaturaRepository;


@RestController
@RequestMapping("/v1")
public class AsignaturaControllerR {
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	// INSERTAR -------------------------------------------------------------------------------------
	@PostMapping("/asignaturas")
	public ResponseEntity<String>insertarAlumno(@RequestBody AsignaturaEntity asignaturaEntity){
		asignaturaRepository.save(asignaturaEntity);
		return new ResponseEntity<>("Inserción correcta!",HttpStatus.OK);
	}
	// LISTAR -------------------------------------------------------------------------------------
	@GetMapping(value = "/asignaturas")
	public Iterable<AsignaturaEntity> listarTodosAlumnos(){
		return asignaturaRepository.findAll();
	}
	
	@GetMapping(value = "/asignaturas/{id}")
	public Optional<AsignaturaEntity> buscarAlumnoPorID(@PathVariable("id")Integer id){
		return asignaturaRepository.findById(id);
	}
	
	@GetMapping(value = "/asignaturas",params  ={"id","nombre"})
	public List<AsignaturaDTO> listarAlumnosPorIdNombre(
			@RequestParam("id") Integer id, 
			@RequestParam("nombre") String nombre){
		
		return asignaturaRepository.buscaAsignaturaporIDyNombre(id, nombre);
	}
	// ACTUALIZAR -------------------------------------------------------------------------------------
	@PutMapping(value="/asignaturas")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AsignaturaEntity asignaturaEntity){
		asignaturaRepository.save(asignaturaEntity);
		return new ResponseEntity<>("actualizacion correcta!",HttpStatus.OK);
	}
	// BORRAR -------------------------------------------------------------------------------------
	@DeleteMapping(value = "/asignaturas/{id}")
	public ResponseEntity<String>MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
		asignaturaRepository.deleteById(id);
		return new ResponseEntity<>("Borrado correcto!",HttpStatus.OK);
	}
}