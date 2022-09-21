import java.util.Random;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class C8e3 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
		int matriz[][] = new int[MAXFILA][MAXCOLUMNA];
		int fila;
		int columna;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		cargar_matriz(matriz);
		imprimir_matriz(matriz);

		try {

			System.out.println("ingrese un numero de fila");
			fila = Integer.valueOf(entrada.readLine());
			System.out.println("ingrese un numero de columna");
			columna = Integer.valueOf(entrada.readLine());
			corrimiento_izquierda(matriz[fila], columna);
			imprimir_matriz(matriz);

		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void corrimiento_izquierda(int arr[], int pos) {
		int indice = pos;
		while (indice < MAXCOLUMNA-1){
		arr[indice] = arr[indice+1];
		indice++;
		}

	}

	public static void cargar_matriz(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo(mat[fila]);
		}
	}

	public static void imprimir_matriz(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo(mat[fila]);
		}
	}

	public static void cargar_arreglo(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}