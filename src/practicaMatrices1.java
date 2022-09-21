import java.util.Random;

/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.*/
public class practicaMatrices1 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
		
		int matriz [][] = new int [MAXFILA][MAXCOLUMNA];
		cargar_matriz(matriz);
		imprimir_matriz(matriz);
		invertirMatriz(matriz);	
		System.out.println("\nNuestra matriz invertida es la siguiente.\n");
		imprimir_matriz(matriz);
	}
	
	public static void invertirMatriz(int mat[][]) {
		
		for(int i = 0; i < MAXFILA; i++) {
			invertirOrdenColumna(mat[i]);
			
		}
		
	}

	public static void invertirOrdenColumna(int[] arr) {
		int aux;
		for(int i = 0; i < MAXCOLUMNA/2; i++) {
			aux = arr[MAXCOLUMNA - 1 -i];
			arr[MAXCOLUMNA - 1 -i] = arr[i];
			arr[i] = aux;
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
