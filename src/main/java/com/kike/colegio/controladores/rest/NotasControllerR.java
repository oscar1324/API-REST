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

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping(value="/v1")
public class NotasControllerR {

	@Autowired
	private NotaRepository  notasRepository;
	@Autowired
	private NotaDAO notasDao;
	
	// INSERTAR ---------------------------------------------------------------------------------------------------
	@PostMapping(value="/notas")
	public ResponseEntity<String> insertarNotas(@RequestBody com.kike.colegio.dtos.NotasRequestDTO nota) {
		
		notasDao.insertarNota(nota.getIdAsignatura(),nota.getIdAlumno(), nota.getNota(), nota.getFecha());

		return new ResponseEntity<>("Insercion Correcta", HttpStatus.OK);

	}
	
	// LISTAR ---------------------------------------------------------------------------------------------------
	@GetMapping(value = "/notas/{id}")
	public Optional<NotaEntity> buscarNotasId(@PathVariable("id") Integer id) {
		return notasRepository.findById(id);
	}
	@GetMapping(value = "/notas" )
	public List<NotaDTO> listarNotas(
			@RequestParam(value = "idAlumno", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha) {
		return notasDao.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha);
	}
	
	// MODIFICAR ---------------------------------------------------------------------------------------------------
	@PutMapping(value="/notas")
	public ResponseEntity<String> actualizarNotas(@RequestBody NotaDTO nota) {
		
		//otasDao.actualizarNota( nota.getIdAlumno(), nota.getIdAsignatura(), nota.getNota(), nota.getNota(), nota.getFecha());

		return new ResponseEntity<>("Insercion Correcta", HttpStatus.OK);

	}
	
	// BORRAR ---------------------------------------------------------------------------------------------------
	@DeleteMapping(value = "/notas/{id}")
	public ResponseEntity<String> MostrarFormularioBorraNotas(@PathVariable("id") Integer id) {
		notasRepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}

}
