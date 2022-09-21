import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*Se tiene un arreglo de enteros de tamaño 20 de secuencias de números
entre 1 y 9, separadas por 0. El arreglo esta precargado, y además
empieza y termina con uno o más separadores 0. Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de
fin de la secuencia ubicada a partir de una posición entera ingresada por
el usuario. Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.*/

public class practica_arreglos_10 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD_NUMERO = 0.4;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		int inicio = 0;
		int fin = 0;
		int num;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		cargar_arreglo_aleatorio_secuencias_int(arreglo);
		imprimirArreglo(arreglo);
		try {
			System.out.println("ingrese un numero de posicion para ubicar la secuencia.");
			num = Integer.valueOf(entrada.readLine());

			if (arreglo[num] == 0) {
				System.out.println("En esa posicion no hay ninguna secuencia");
			} else {
				inicio = encontrarInicio(arreglo, num);
				fin = encontrarFin(arreglo, num);
				System.out.println("el inicio de la secuencia es " + inicio + " y el fin es " + fin);
			}

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static int encontrarFin(int[] arr, int pos) {
		int i = pos;
		while ((pos < MAX )&&(arr[i] != 0)) {
			i++;
			
		}
		return i -1;
	}

	public static int encontrarInicio(int[] arr, int pos) {
		int i = pos;
		while ((pos < MAX )&&(arr[i] != 0)) {
			pos--;

		}

		return i;
	}

	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD_NUMERO) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
