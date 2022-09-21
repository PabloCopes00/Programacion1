import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Hacer un programa que dado una matriz de enteros de tamaño 4*20 que
se encuentra precargada, solicite al usuario el ingreso de una fila y dos
números enteros (columnas de la matriz), y ordene de forma creciente la
matriz en la fila indicada entre las dos posiciones columnas ingresadas.
 */

public class practicaMatrices9 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int fila, col1, col2;
		cargar_matriz_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("inserte un numero de fila");
		fila = pedirIntUsuario();
		System.out.println("inserte un numero de columna 1");
		col1 = pedirIntUsuario();
		System.out.println("inserte un numero de columna 2");
		col2 = pedirIntUsuario();
		buscarSecuenciaParaOrdenar(matint[fila], col1, col2);
		imprimir_matriz_int(matint);

	}

	public static void buscarSecuenciaParaOrdenar(int[] matint, int col1, int col2) {
		int inicio = 0;
		int fin = col1 - 1;

		while (inicio < col2) {
			inicio = buscarInicio(matint, fin + 1);
			if (inicio < col2) {
				fin = buscarFin(matint, inicio);
				ordenarSecuencias(matint, inicio, fin);
			}
		}

	}

	public static void ordenarSecuencias(int[] arr, int inicio, int fin) {
		int aux;
		for (int i = inicio; i <= fin; i++) {
			for (int j = i+1; j <= fin; j++) {
				if (arr[j] < arr[i]) {
					aux = arr[j];
					arr[j] = arr[i];
					arr[i] = aux;

				}
			}
		}
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

	public static int pedirIntUsuario() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return num;
	}

	public static void cargar_matriz_secuencias_int(int[][] mat) {
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

	public static void imprimir_matriz_int(int[][] mat) {
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