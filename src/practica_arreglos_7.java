/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica_arreglos_7 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int arreglo[] = { 1, 3, 8, 10, 16, 23, 28, 30, 38, 50 };
		int num;
		int pos;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		imprimirArreglo(arreglo);
		try {
			System.out.println("ingrese un numero para insertar en el arreglo");
			num = Integer.valueOf(entrada.readLine());
			pos = obtenerPosicion(arreglo, num);
			corrimientoDerecha(arreglo, pos);
			arreglo[pos] = num;
			imprimirArreglo(arreglo);

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static int obtenerPosicion(int arr[], int num) {
		int i = 0;
		while ((i < MAX) && (arr[i] < num)) {
			i++;
		}
		return i;

	}

	public static void corrimientoDerecha(int arr[], int pos) {

		int i = MAX - 1;
		while (i > pos) {
			arr[i] = arr[i - 1];
			i--;
		}

	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}

}
