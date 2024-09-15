package fp.bicis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RedEstaciones {

	private String nombre;
	private SortedSet<Estacion> estaciones;
	
	public RedEstaciones() {
		this.nombre = "";
	}
	
	public RedEstaciones(String nombre) {
		this.nombre = nombre;
	}
	
	public RedEstaciones(String nombre, Set<Estacion> estaciones) {
		this.nombre = nombre;
		this.estaciones = new TreeSet<Estacion>(estaciones);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SortedSet<Estacion> getEstaciones() {
		return estaciones;
	}
	
	public Integer getNumEstaciones() {
		return estaciones.size();
	}
	
	public Integer getNumPuestos() {
		Integer res = 0;
		for(Estacion e:estaciones) {
			if(e.getNumPuestos() != null) {
				res += e.getNumPuestos();
			}
		}
		return res;
	}
	
	//Operaciones
	// 1)
	public void agregarEstacion(Estacion e) {
		estaciones.add(e);
	}
	// 2)
	public List<String> getEstacionesBicisDisponibles(){
		List<String> ls_estaciones = new ArrayList<>();
		for(Estacion e:estaciones) {
			if(e.getBicisDisponibles() > 0) {
				ls_estaciones.add(e.getId());
			}
		}
		return ls_estaciones;
	}
	// 3)
	public List<String> getEstacionesBicisDisponibles(Integer k){
		List<String> ls_estaciones = new ArrayList<>();
		for(Estacion e:estaciones) {
			if(e.getBicisDisponibles() > k) {
				ls_estaciones.add(e.getId());
			}
		}
		return ls_estaciones;
	}
	// 4)
	public SortedSet<String> getEstacionesCercanas(Coordenadas cs, Double distancia){
		SortedSet<String> estacionesCercanas= new TreeSet<String>();
		for (Estacion e:estaciones) {
			if (e.getBicisDisponibles() > 0 && e.getUbicacion().getDistancia(cs) < distancia) {
				estacionesCercanas.add(e.getId());
			}
		}
		return estacionesCercanas;
	}
	// 5)
	public String getEstacionMasBicisDisponibles() {
		Integer max = 0;
		String est = null;
		for(Estacion e:estaciones) {
			if(max < e.getBicisDisponibles()) {
				max = e.getBicisDisponibles();
				est = e.getId();
			}
		}
		return est;
	}
	// 6)
	public Double getOcupacionMediaEstacionesConBicis() {
		Integer numPuestosTotal = estaciones.stream().filter(x->x.tieneBicisDisponibles()).mapToInt(x->x.getNumPuestos()).sum();
		Integer numPuestosVaciosTotal = estaciones.stream().filter(x->x.tieneBicisDisponibles()).mapToInt(x->x.getPuestosVacios()).sum();
		return (double) numPuestosVaciosTotal/numPuestosTotal * 100;
	}	
	
	// 7)
	public Boolean tienenBicisDisponiblesTodasEstacionesCercanas(Coordenadas cs, Double distancia) {
		Boolean res = true;
		for (Estacion e:estaciones) {
			if (e.getUbicacion().getDistancia(cs) < distancia && e.getBicisDisponibles() == 0) {
				return false;
			}
		}
		return res;
	}

	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this == null || this.getClass() == obj.getClass()) {
			return false;
		}
		RedEstaciones other = (RedEstaciones) obj;
		return Objects.equals(getNombre(),other.getNombre());
	}
	
}
