
/*
 
Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y luego inserte el numero en la matriz en la fila
indicada manteniendo su orden.
  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class practicaMatrices6 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int num, fila;
		cargar_matriz(matint);
		ordenarMatriz(matint);
		imprimirMatriz(matint);
		System.out.println("inserte un numero para insertar:");
		num = pedirIntUsuario();
		System.out.println("inserte un numero de fila:");
		fila = pedirIntUsuario();
		insertarNumero(matint[fila], num);
		imprimirMatriz(matint);
	}

	public static void ordenarMatriz(int[][] matint) {
		for (int i = 0; i < MAXFILA; i++) {
			ordenarArreglo(matint[i]);
		}
	}

	public static void ordenarArreglo(int[] arr) {
		int temp;
		for (int i = 1; i < MAXCOLUMNA; i++) {
			for (int j = 0; j < MAXCOLUMNA - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void insertarNumero(int[] matint, int num) {
		int i = 0;
		boolean encontrado = false;
		while (i < MAXCOLUMNA && !encontrado) {
			if (matint[i] > num) {
				corrimintoDerecha(matint, i);
				matint[i] = num;
				encontrado = true;
			}
			i++;
		}

	}

	public static void corrimintoDerecha(int[] matint, int pos) {
		int inicio = MAXCOLUMNA - 1;
		while (inicio > pos) {
			matint[inicio] = matint[inicio - 1];
			inicio--;
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

	public static void cargar_matriz(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo(mat[fila]);
		}
	}

	public static void cargar_arreglo(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

	public static void imprimirMatriz(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo(mat[fila]);
		}
	}

	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
