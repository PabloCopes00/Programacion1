import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia
//con el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe
//realizar de manera explícita, hay que hacer un método que incluya una iteración de
//intercambio.

public class practica_arreglos_1 {

	public static final int MINVALOR = 01;
	public static final int MAXVALOR = 10;
	public static final int MAX = 10;

	public static void main(String[] args) {

		int arreglo[] = new int[MAX];
		cargar_arreglo_aleatorio_int(arreglo);
		imprimir_arreglo(arreglo);
		orden_intercambiando(arreglo);
		imprimir_arreglo(arreglo);

	}

	public static void orden_intercambiando(int[] arreglo) {

		for (int i = 0; i < (MAX / 2); i++) {
			int aux = 0;
			aux = arreglo[i];
			arreglo[i] = arreglo[MAX - 1 - i];
			arreglo[MAX - 1 - i] = aux;
		}
	}

	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}

	public static void cargar_arreglo_aleatorio_int(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}
}
