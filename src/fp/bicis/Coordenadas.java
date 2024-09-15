package fp.bicis;

import java.util.Objects;

import fp.utils.Checkers;

public class Coordenadas {

	private Double latitud;
	private Double longitud;
	private UnidadMedida unidad;
	
	final Double radioTierra = 6371.0;
	
	//Constructores
	public Coordenadas() {
		//Restricciones:
		//R1:
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º",latitud >= -90.0 && latitud <= 90.0);
		//R2:
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º.",longitud >= -180.0 && longitud <= 180.0);
		this.latitud = 0.0;
		this.longitud = 0.0;
		this.unidad = UnidadMedida.GRADOS;
	}
	
	public Coordenadas(Double latitud, Double longitud) {
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º",latitud >= -90.0 && latitud <= 90.0);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º.",longitud >= -180.0 && longitud <= 180.0);
		this.latitud = latitud;
		this.longitud = longitud;
		this.unidad = UnidadMedida.GRADOS;
	}
	
	public Coordenadas(Double latitud, Double longitud, UnidadMedida unidad) {
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º",latitud >= -90.0 && latitud <= 90.0);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º.",longitud >= -180.0 && longitud <= 180.0);
		this.latitud = latitud;
		this.longitud = longitud;
		this.unidad = unidad;
	}
	
	public Coordenadas(String coordenada) {
		String[] sp = coordenada.split(",");
		Checkers.check("Cadena con formato no válido", sp.length == 2);
		Double lat = Double.parseDouble(sp[0].trim());
		Double lon = Double.parseDouble(sp[1].trim());
		Checkers.check("La latitud debe estar comprendida entre -90º y +90º",latitud >= -90.0 && latitud <= 90.0);
		Checkers.check("La longitud debe estar comprendida entre -180º y +180º.",longitud >= -180.0 && longitud <= 180.0);
		this.latitud = lat;
		this.longitud = lon;
		this.unidad = UnidadMedida.GRADOS;
	}
	
	//Métodos GET
	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}
	
	public UnidadMedida getUnidad() {
		return unidad;
	}
	
	//Métodos
	public Double getDistancia(Coordenadas c){
		return Math.sqrt(Math.pow(c.latitud-this.latitud,2)+Math.pow(c.longitud-this.longitud,2));
	}
	
	public Double getDistanciaHaversine (Coordenadas cord) {
		double dLat = Math.toRadians(cord.latitud - this.latitud);
		double dLon = Math.toRadians(cord.longitud - this.longitud);
		double a = Math.pow(Math.sin(dLat/2),2) + Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(cord.latitud)) * Math.pow(Math.sin(dLon/2),2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return radioTierra * c;
	}
	
	public Coordenadas aRadianes() {
		Coordenadas coordenadas = null;
		if(unidad == UnidadMedida.RADIANES) {
			coordenadas = new Coordenadas(latitud,longitud,unidad);
		}else {
			coordenadas = new Coordenadas(latitud*(Math.PI/180),longitud*(Math.PI/180),UnidadMedida.RADIANES);
		}
		return coordenadas;
	}
	
	public Coordenadas aGrados() {
		Coordenadas coordenadas = null;
		if(unidad == UnidadMedida.GRADOS) {
			coordenadas = new Coordenadas(latitud,longitud,unidad);
		}else {
			coordenadas = new Coordenadas(latitud*(180/Math.PI),longitud*(180/Math.PI),UnidadMedida.GRADOS);
		}
		return coordenadas;
	}
	
	public int hashCode() {
		return Objects.hash(latitud,longitud,unidad);
	}
	
	public boolean equals(Object o) {
		boolean r = false;
		if (this == o) {
			r = true;
		}
		if (o == null || getClass() != o.getClass()) {
			r = false;
		}
		Coordenadas c = (Coordenadas) o;
		r = this.getLatitud().equals(c.getLatitud()) && this.longitud.equals(c.getLongitud()) && this.getUnidad().equals(c.getUnidad());
		return r;
	}
	
	public String toString() {
		return "Coordenadas[Latitud = "+latitud+", Longitud = "+longitud+", Unidad = "+unidad+"]";
	}
}
