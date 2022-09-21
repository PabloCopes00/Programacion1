
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
menor posición del arreglo.*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica_arreglos_3 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int num1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int arreglo[] = new int[MAX];
		cargarArregloAleatorio(arreglo);
		imprimirArreglo(arreglo);
		try {
			System.out.println("ingrese una posicion para hacer un corrimiento.");
			num1 = Integer.valueOf(entrada.readLine());
			corrimientoNroUsuario(arreglo, num1);
			imprimirArreglo(arreglo);
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void corrimientoNroUsuario(int arr[], int pos) {
		int indice = pos;

		while (indice < MAX - 1) {
			arr[indice] = arr[indice + 1];
			indice++;
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
