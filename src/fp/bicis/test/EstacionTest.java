package fp.bicis.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.bicis.Coordenadas;
import fp.bicis.Estacion;
import fp.bicis.RedEstaciones;
import fp.bicis.UnidadMedida;

public class EstacionTest {
	
	public static void mostrarCoordenadas(Coordenadas c) {
		System.out.println("Latitud = "+c.getLatitud());
		System.out.println("Longitud = "+c.getLongitud());
		System.out.println("Unidad = "+c.getUnidad());
	}
	
	public static void metodosRedEstaciones(RedEstaciones rE) {
		System.out.println("Métodos de RedEstaciones:");
		System.out.println("TEST de getEstacionesBicisDisponibles(): \n"+rE.getEstacionesBicisDisponibles());
		Integer k = 3;
		System.out.println("TEST de getEstacionesBicisDisponibles(Integer k): \n"+rE.getEstacionesBicisDisponibles(k));
		Coordenadas c1 = new Coordenadas(37.4129235511391,-5.98890593824315);
		Double distancia = 0.03;
		System.out.println("TEST de getEstacionesCercanas(Coordenadas cs, Double distancia): \n"+rE.getEstacionesCercanas(c1, distancia));
		System.out.println("TEST de getEstacionMasBicisDisponibles(): \n"+rE.getEstacionMasBicisDisponibles());
		System.out.println("TEST de getOcupacionMediaEstacionesConBicis(): \n"+rE.getOcupacionMediaEstacionesConBicis());
		System.out.println("TEST de tienenBicisDisponiblesTodasEstacionesCercanas(Coordenadas cs, Double distancia): \n"+rE.tienenBicisDisponiblesTodasEstacionesCercanas(c1, distancia));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Coordenadas
		Coordenadas c1 = new Coordenadas(37.4129235511391,-5.98890593824315);
		Coordenadas c2 = new Coordenadas(37.381578045327934,-5.96522396639778);
		Coordenadas c3 = new Coordenadas(37.41011155757378,-6.005722268777397);
		Coordenadas c4 = new Coordenadas(40.00011155757378,-4.615022268777397);
		
		mostrarCoordenadas(c1);
	
		//Estaciones
		Estacion e1 = new Estacion("001","GLORIETA OLIMPICA", 20, 19, c1);
		Estacion e2 = new Estacion("002","GRAN PLAZA",35,31,c2);
		Estacion e3 = new Estacion("003","PUERTA DE LA BARQUETA",40,30,c3);
		Estacion e4 = new Estacion("004","REINA MERCEDES",30,0,c4);
		
		//RedEstacion
		RedEstaciones rd = new RedEstaciones("Sevici",Set.of(e1,e2,e3,e4));
		
		metodosRedEstaciones(rd);
		
	}

}
