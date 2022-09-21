/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer ocurrencia del numero
(un número igual) en el arreglo (si existe). Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda (queda una copia de la última posición del arreglo en la
anteúltima posición).*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica_arreglos_5 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		int num;
		int pos;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		cargarArregloAleatorio(arreglo);
		imprimirArreglo(arreglo);
		try {
			System.out.println("ingrese un numero para eliminar primera ocurrencia del arreglo");
			num = Integer.valueOf(entrada.readLine());
			pos = obtenerPosArreglo(arreglo, num);
			corrimientoIzquierda(arreglo, pos);
			imprimirArreglo(arreglo);

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static int obtenerPosArreglo(int arr[], int num) {
		boolean cortar = true;
		int index = 0;
		while ((index < MAX) && cortar) {
			if (arr[index] == num) {
				cortar = false;
			}
			index++;
		}

		return index-1;
	}

	private static void corrimientoIzquierda(int[] arr, int pos) {
		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];

		}

	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}

	public static void cargarArregloAleatorio(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}
}
