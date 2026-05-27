package com.krakedev.tallerjdbc.empleados.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,length = 100)
	private String nombre;
	@Column(nullable = false,length = 100)
	private String apellido;
	@Column(nullable = false,length = 100)
	private String cargo;
	@Column(nullable = false)
	private double salario;
	@Column(nullable = false)
	private boolean activo;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, String cargo, double salario, boolean activo) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.salario = salario;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo
				+ ", salario=" + salario + ", activo=" + activo + "]";
	}			
}
