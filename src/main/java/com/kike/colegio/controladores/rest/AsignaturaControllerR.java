package com.kike.colegio.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/v2")
public class AsignaturaControllerR {
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	// INSERTAR -------------------------------------------------------------------------------------------------------------------
	@PostMapping("/asignaturas")
	public ResponseEntity<String> insertarAlumno (@RequestBody AsignaturaRepository asignatura){
		
		//asignaturaRepository.save(asignatura);
		
		return new ResponseEntity<>("Inserción correcta", HttpStatus.OK);
		
	}
	
	
	// LISTAR -------------------------------------------------------------------------------------------------------------------
	// llamada en general
	@GetMapping(value = "/asignaturas")
	public Iterable<AsignaturaEntity> listarTodosAlumnos(){
		/* Si quiero obtener un alumno por id o algun otro parametro le introducto un @ReqeustParam y el campo*/
		return asignaturaRepository.findAll();
	}
	
	// Llamada por id + nombre
	@GetMapping(value = "/asignaturas", params = { "id", "nombre"})
	public List<AsignaturaDTO> listarTodosAlumnos(
			@RequestParam("id") Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam("curso") Integer curso,
			@RequestParam("tasa") Double tasa){
		/* Si quiero obtener un alumno por id o algun otro parametro le introducto un @ReqeustParam y el campo*/
		return asignaturaRepository.buscaAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa);
	}
	
	// ACTUALIZAR -------------------------------------------------------------------------------------------------------------------
	// BORRAR -------------------------------------------------------------------------------------------------------------------
	
}
