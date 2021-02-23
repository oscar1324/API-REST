package com.kike.colegio.dtos;


public class NotasRequestDTO {
	
	
	int idAlumno;
	int idAsignatura;
	Double nota;
	String fecha;



	public NotasRequestDTO() {
		super();
	}



	public NotasRequestDTO(int idAlumno, int idAsignatura, Double nota, String fecha) {
		super();
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}



	public int getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}



	public int getIdAsignatura() {
		return idAsignatura;
	}



	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}



	public Double getNota() {
		return nota;
	}



	public void setNota(Double nota) {
		this.nota = nota;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




}