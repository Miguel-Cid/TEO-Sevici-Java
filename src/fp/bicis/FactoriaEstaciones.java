package fp.bicis;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoriaEstaciones {

	public static void leerEstacion(String rutaFichero) {
		List<Estacion> res = new ArrayList<Estacion>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));
			for(String linea:lineas) {
				res.add(new Estacion(linea));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
