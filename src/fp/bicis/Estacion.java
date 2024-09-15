package fp.bicis;

import java.util.Objects;

import fp.utils.Checkers;

public class Estacion implements Comparable<Estacion> {

	private String id;
	private String nombre;
	private Integer numPuestos;
	private Integer bicisDisponibles;
	private Coordenadas ubicacion;
	
	public Estacion(String id, String nombre, Integer numPuestos, Integer bicisDisponibles, Coordenadas ubicacion) {
		Checkers.check("El número de puestos debe ser mayor 0", numPuestos > 0);
		Checkers.check("El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos", bicisDisponibles >= 0 && bicisDisponibles <= numPuestos);
		this.id = id;
		this.nombre = nombre;
		this.numPuestos = numPuestos;
		this.bicisDisponibles = bicisDisponibles;
		this.ubicacion = ubicacion;
	}
	
	public Estacion(String linea) {
		String[] sp = linea.split(","); 
		Checkers.check("El número de puestos debe ser mayor 0", Integer.parseInt(sp[2]) > 0);
		Checkers.check("El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos", Integer.parseInt(sp[3]) >= 0 && Integer.parseInt(sp[3]) <= numPuestos);
		this.id = sp[0];
		this.nombre = sp[1];
		this.numPuestos = Integer.parseInt(sp[2]);
		this.bicisDisponibles = Integer.parseInt(sp[3]);
		this.ubicacion = parsearCoordenada(sp[4]);
	}
	
	public Coordenadas parsearCoordenada(String linea) {
		String[] sp = linea.replace("[","").replace("]","").split("-");
		return new Coordenadas(Double.parseDouble(sp[0]),Double.parseDouble(sp[1]));		
	}
	
	//Propiedades derivadas
	public Integer getPuestosVacios() {
		return this.numPuestos - this.bicisDisponibles;
	}
	
	public boolean tieneBicisDisponibles() {
		boolean res = false;
		if(bicisDisponibles > 0) {
			res = true;
		}
		return res;
	}
	
	public Double getOcupacion() {
		return (double) (this.bicisDisponibles/this.numPuestos)*100;
	}
	
	//Métodos GET	
	public Integer getBicisDisponibles() {
		return bicisDisponibles;
	}

	public void setBicisDisponibles(Integer bicisDisponibles) {
		this.bicisDisponibles = bicisDisponibles;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumPuestos() {
		return numPuestos;
	}

	public Coordenadas getUbicacion() {
		return ubicacion;
	}
	
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Estacion other = (Estacion) o;
		return Objects.equals(getId(), other.getId());
	}
	
	public int compareTo(Estacion e) {
		int r = getId().compareTo(e.getId());
		return r;
	}
	
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + ", numPuestos=" + numPuestos + ", bicisDisponibles="
				+ bicisDisponibles + ", ubicacion=" + ubicacion + ", getPuestosVacios()=" + getPuestosVacios()
				+ ", tieneBicisDisponibles()=" + tieneBicisDisponibles() + ", ocupacion()=" + getOcupacion() + "]";
	}
	
	
	
}
