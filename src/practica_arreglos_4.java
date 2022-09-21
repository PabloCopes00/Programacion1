/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo
(posición 0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor
del arreglo) y colocar el numero en el arreglo en la posición indicada.*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica_arreglos_4 {

	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		int pos;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		cargarArregloAleatorio(arreglo);
		imprimirArreglo(arreglo);

		try {
			System.out.println("ingrese un numero para insertar en la primiera posicion.");
			pos = Integer.valueOf(entrada.readLine());
			corrimientoDerecha(arreglo);
			arreglo[0] = pos;
			imprimirArreglo(arreglo);

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}
	
	public static void corrimientoDerecha(int arr[]){
		int index = MAX-1;
		while(index > 0) {
			arr[index] = arr[index-1];
			index--;
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
