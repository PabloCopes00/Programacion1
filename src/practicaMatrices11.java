import java.util.Random;

/*
Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada permita encontrar por cada fila la posición de inicio y fin de la
secuencia cuya suma de valores sea mayor.
*/
public class practicaMatrices11 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		cargarMatSecuenciasInt(matint);
		imprimirMatInt(matint);
		buscarSumaSecuenciaMayorMatrizXFila(matint);

	}

	public static void buscarSumaSecuenciaMayorMatrizXFila(int[][] matint) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			buscarSumaSecuenciaMayorArregloXFila(matint[fila], fila);

		}
	}

	public static void buscarSumaSecuenciaMayorArregloXFila(int[] matint, int fila) {
		int inicio = 0;
		int fin = -1;
		int suma, iniSec = 0, finSec = 0, resultado = 0;
		while (inicio < MAXCOLUMNA) {
			inicio = buscarInicio(matint, fin + 1);

			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(matint, inicio);
				suma = sumarSecuencia(matint, inicio, fin);
				if (suma >= resultado) {
					resultado = suma;
					iniSec = inicio;
					finSec = fin;
				}

			}
		}
		System.out.println("Para la fila " + (fila + 1) + " la secuencia que comienza en " + iniSec + " y termina en "
				+ finSec + ", su suma de valores es la mayor resultando: " + resultado);
	}

	private static int sumarSecuencia(int[] matint, int inicio, int fin) {
		int suma = 0;
		for (int i = inicio; i <= fin; i++) {
			suma += matint[i];
		}

		return suma;
	}

	private static int buscarFin(int[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != 0)) {
			inicio++;
		}

		return inicio - 1;
	}

	private static int buscarInicio(int[] matint, int i) {
		while ((i < MAXCOLUMNA) && (matint[i] == 0)) {
			i++;
		}
		return i;
	}

	public static void cargarMatSecuenciasInt(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo_secuencias_int(mat[fila]);
		}
		System.out.println(" ");
	}

	public static void cargar_arreglo_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA - 1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimirMatInt(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo_int(mat[fila]);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
