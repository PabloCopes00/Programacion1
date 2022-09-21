import java.util.Random;
/*
 Final Programación 1 – TUDAI 5/8/2015
Dada una matriz de tamaño M*N cuyas filas tienen secuencias de enteros separadas por ceros, determinar
el tamaño de secuencias que se repite mayor cantidad de veces.
 */

public class final2015 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int arr[] = new int[MAXCOLUMNA];
		cargarMatriz(matint);
		imprimirMatriz(matint);
		averiguarSecRepiteMayorCantVeces(matint, arr);

	}

	public static void averiguarSecRepiteMayorCantVeces(int[][] matint, int[] arr) {
		int resultado = 0;
		for (int i = 0; i < MAXFILA; i++) {
			procesarSecuencias(matint[i], arr);

		}
		resultado = identificarSecMayor(arr);
		System.out.println("");
		imprimir_arreglo_int(arr);
		System.out.println("\nEL tamaño de secuencia que mas se repite es: " + resultado);

	}

	public static void procesarSecuencias(int[] matarr, int[] arr) {
		int i = 0;
		int inicio = 0;
		int fin = -1;
		int tamanio = 0;

		while (i < MAXCOLUMNA) {
			inicio = buscarInicio(matarr, fin + 1);
			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(matarr, inicio);
				tamanio = fin - inicio + 1;
				arr[tamanio] += 1;
			}
			i++;
		}

	}

	public static int identificarSecMayor(int[] arr) {
		int suma = 0;
		int resultado = 0;

		for (int i = 0; i < MAXCOLUMNA; i++) {
			if (arr[i] > suma) {
				suma = arr[i];
				resultado = i;
			}
		}
		return resultado;
	}

	public static int buscarInicio(int[] matint, int i) {
		while ((i < MAXCOLUMNA) && (matint[i] == 0)) {
			i++;
		}
		return i;
	}

	public static int buscarFin(int[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != 0)) {
			inicio++;
		}

		return inicio - 1;
	}

	public static void cargarMatriz(int[][] mat) {
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

	public static void imprimirMatriz(int[][] mat) {
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
