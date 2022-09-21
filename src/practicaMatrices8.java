import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y elimine la primer ocurrencia de numero en la
fila indicada (un número igual) si existe. 
 */

public class practicaMatrices8 {
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
		System.out.println("inserte un numero para eliminar: ");
		num = pedirIntUsuario();
		eliminarPrimeraOcurrenciaMatriz(matint, num);
		imprimir_matriz_int(matint);

	}

	public static void eliminarPrimeraOcurrenciaMatriz(int[][] matint, int num) {
		int j = 0;
		int i = 0;
		boolean encontrado = false;
		while (i < MAXFILA && !encontrado) {
			while (((j < MAXCOLUMNA) && (matint[i][j] <= num)) && !encontrado) {
				if (matint[i][j] == num) {
					corrimientoIzq(matint[i], j);
					encontrado = true;
				}
				j++;
			}
			i++;
		}

	}

	public static void corrimientoIzq(int[] arr, int i) {
		while (i < MAXCOLUMNA - 1) {
			arr[i] = arr[i + 1];
			i++;

		}

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