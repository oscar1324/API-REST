package com.kike.colegio.controladores.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dtos.ComboDTO;

@RestController
@RequestMapping(value="/v1")
public class CombosRestController {

	@Autowired
	private ComboDAO combodao;
	@GetMapping(value="/combos/alumnos")
	public List<ComboDTO> comboAlumnos(){
		return combodao.comboAlumnos();
		
	}
	@GetMapping(value="/combos/asignaturas")
	public List<ComboDTO> comboAsignaturas(){
		return combodao.comboAsignaturas();
		
	}
	@GetMapping(value="/combos/municipios")
	public List<ComboDTO> comboMunicipios(){
		return combodao.comboMunicipios();
		
	}
	
}