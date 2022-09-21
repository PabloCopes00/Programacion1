import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 Hacer un programa que dada la matriz de secuencias de enteros definida
y precargada, permita obtener a través de métodos la posición de inicio y
la posición de fin de la secuencia ubicada a partir de una posición entera
y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
por pantalla ambas posiciones obtenidas.  
 */

public class practicaMatrices13 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int num;
		cargar_matriz_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("inserte un numero para borrar todas las secuencias de igual tamaño.");
		num = pedirIntUsuario();
		eliminarSecMismoTamanioMatriz(matint, num);
		System.out.println("\nLa matriz quedo de la siguiente manera:\n");
		imprimir_matriz_int(matint);
	}

	public static void eliminarSecMismoTamanioMatriz(int[][] matint, int num) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			eliminarSecMismoTamanio(matint[fila], num);
		}
	}

	public static void eliminarSecMismoTamanio(int[] arr, int num) {
		int j = 0;
		int inicio = 0;
		int fin = -1;
		boolean sonIguales = false;

		while (j < MAXCOLUMNA) {
			inicio = buscarInicio(arr, fin + 1);
			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(arr, inicio);
				sonIguales = analizarSecuencia(inicio, fin, num);
				if (sonIguales) {
					for (int i = inicio; i <= fin; i++) {
						corrimientoIzq(arr, inicio);
					}
				}
			}
			j++;
		}

	}

	public static void corrimientoIzq(int[] arr, int inicio) {
		for (int i = inicio; i < MAXCOLUMNA - 1; i++) {
			arr[i] = arr[i + 1];
		}

	}

	public static boolean analizarSecuencia(int inicio, int fin, int num) {
		if ((fin - inicio + 1) == num) {
			return true;
		} else {
			return false;
		}
	}

	public static int buscarFin(int[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != 0)) {
			inicio++;
		}

		return inicio - 1;
	}

	public static int buscarInicio(int[] matint, int i) {
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
