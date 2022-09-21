/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en el arreglo. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán
tantas copias de la última posición del arreglo como cantidad de ocurrencias del número).*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica_arreglos_6 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		int num;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		cargarArregloAleatorio(arreglo);
		imprimirArreglo(arreglo);
		try {
			System.out.println("ingrese un numero para eliminar del arreglo");
			num = Integer.valueOf(entrada.readLine());
			ocurrencia(arreglo, num);
			imprimirArreglo(arreglo);

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}
public static void ocurrencia(int arr[], int num) {
	for (int i = 0; i < MAX; i++) {
		while (arr[i]==num) {
			corrimientoIzquierda(arr,i);
		}

	}
}
	public static void corrimientoIzquierda(int[] arr, int num) {
		for (int i = num; i < MAX-1; i++) {
			arr[i] = arr[i+1];
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
