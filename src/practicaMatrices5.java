import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
  
  Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando.

*/

public class practicaMatrices5 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
		int matriz[][] = new int[MAXFILA][MAXCOLUMNA];
		int num;
		cargar_matriz(matriz);
		imprimir_matriz(matriz);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("ingrese un numero para eliminar la primera ocurrencia.");
			num = Integer.valueOf(entrada.readLine());
			eliminarNumero(matriz, num);
			imprimir_matriz(matriz);

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void eliminarNumero(int mat[][], int num) {
		boolean encontrado = false;

		int i = 0;
		while (i < MAXFILA && !encontrado) {
			int j = 0;
			while (j < MAXCOLUMNA && !encontrado) {

				if (mat[i][j] == num) {
					corrimientoIzquierda(mat[i], j);
					System.out.println("el numero se elimino correctamente.");
					encontrado = true;

				}
				j++;
			}
			i++;
		}

		if (!encontrado) {
			System.out.println("el numero no se encontro.");
		}
	}

	public static void corrimientoIzquierda(int mat[], int i) {
		
		while (i < MAXCOLUMNA - 1) {
			mat[i] = mat[i + 1];
			i++;
		}

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

	public static void imprimir_matriz(int[][] mat) {
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
