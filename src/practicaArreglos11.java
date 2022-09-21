import java.util.Random;

/*
 Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la secuencia cuya suma de valores sea mayor. 
 */
public class practicaArreglos11 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD_NUMERO = 0.4;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arreglo);
		imprimirArreglo(arreglo);
		encontrarInicio(arreglo);

	}

	public static void encontrarInicio(int arreglo[]) {
		int inicio = 0;
		int fin = -1;
		int totalSecuencia;
		int inicioSecuencia = 0;
		int resultado = 0;
		while (inicio < MAX) {
			inicio = obtenerInicio(arreglo, fin + 1);
			System.out.println("------------------\n" + "Inicio " + inicio);
			fin = obtenerFin(arreglo, inicio);
			System.out.println("Fin " + fin);
			totalSecuencia = sumarSecuencia(arreglo, inicio, fin);
			System.out.println("Suma de la secuencia: " + totalSecuencia);
			if (totalSecuencia > resultado) {
				resultado = totalSecuencia;
				inicioSecuencia = inicio;
			}
		}
		System.out.println("------------------\nLa secuencia cuya suma de valores es mayor, da como resultado: " + resultado
				+ "\nY dicha secuencia empieza en la posicion: " + inicioSecuencia);

	}

	

	public static int sumarSecuencia(int[] arreglo, int inicio, int fin) {
		int suma = 0;
		for (int i = inicio; i <= fin; i++) {
			suma += arreglo[i];

		}
		return suma;
	}

	public static int obtenerInicio(int arreglo[], int inicio) {
		while ((inicio < MAX) && (arreglo[inicio] == 0)) {
			inicio++;
		}
		return inicio;
	}

	public static int obtenerFin(int arreglo[], int fin) {
		while ((fin < MAX) && (arreglo[fin] != 0)) {
			fin++;
		}
		return (fin - 1);
	}

	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD_NUMERO) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
