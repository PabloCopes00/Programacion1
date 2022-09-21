import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, obtenga la cantidad de números pares que tiene y la imprima.
public class practica_arreglos_2 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		int cantidadPares;
		cargarArregloAleatorio(arreglo);
		imprimirArreglo(arreglo);
		cantidadPares = obtenerCantidadPares(arreglo);
		System.out.println("en el arreglo hay " + cantidadPares + " numeros pares.");


	}

	public static int obtenerCantidadPares(int[] arreglo) {
		int cantidad = 0;
		for (int i = 0; i < MAX; i++) {
			if ((arreglo[i] % 2) == 0) {
				cantidad++;
			}

		}
		return cantidad;
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
