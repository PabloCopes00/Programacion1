/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima.*/
import java.util.Random;
public class practicaMatrices2 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
     int matriz [][] = new int [MAXFILA][MAXCOLUMNA];
    
		cargar_matriz(matriz);
		imprimir_matriz(matriz);
		contarParesMatriz(matriz);
	}

	public static void contarParesMatriz(int[][] matriz) {
		int totalPares = 0;
		for(int i = 0; i < MAXFILA; i++) {
			int pares;
			pares = contarPares(matriz[i]);
			totalPares += pares;
	}
		System.out.println("\nTenemos un total de " + totalPares + " pares en la matriz.");
	}
	private static int contarPares(int[] arr) {
		int cantPares = 0;
		int i = 0;
		
		while(i< MAXCOLUMNA) {
			if (arr[i]%2==0) {
				cantPares++;
			}
			i++;
		}
		
		
		
		return cantPares;
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
