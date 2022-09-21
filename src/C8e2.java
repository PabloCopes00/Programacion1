import java.util.Random;

public class C8e2 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {

		int matriz[][] = new int[MAXFILA][MAXCOLUMNA];
		int pares;

		cargar_matriz(matriz);
		imprimir_matriz(matriz);
		pares = obtener_numeros_pares(matriz);
		System.out.println("En esta matriz hay " + pares + " numeros Pares");
	}

	public static int obtener_numeros_pares(int matriz [][]) {
		  int contador = 0;
		  
		   for(int i=0; i< MAXFILA;i++) {
			   for(int j = 0; j < MAXCOLUMNA; j++) {
				   if((matriz[i][j]%2)==0){
					  contador++;
				   }
			   }
			   
		   }
		   
		   return contador;
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