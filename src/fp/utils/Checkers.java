package fp.utils;

public class Checkers {

	public static void check(String textoRestriccion, boolean condicion) {
		if(!condicion) {
			throw new IllegalArgumentException(textoRestriccion);
		}
	}
	
	public static void checkNotNull(Object... parametros) {
		for(int i=0;i<parametros.length;i++) {
			if(parametros[i] == null) {
				throw new IllegalArgumentException("El parámetro "+(i+1)+" es nulo");
			}
		}
	}
}
