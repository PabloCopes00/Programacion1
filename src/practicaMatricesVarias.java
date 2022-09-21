
public class practicaMatricesVarias {
	public static final int MAXF = 4;
	public static final int MAXC = 5;

	public static void main(String[] args) {

		int matriz[][] = new int[MAXF][MAXC];

		for (int i = 0; i < MAXF; i++) {
			for (int j = 0; j < MAXC; j++) {
				matriz[i][j] = j+1;
			}
		}
		imprimir_matriz(matriz);
	}
	
	
	
	
	public static void imprimir_matriz(int[][] mat) {
		for (int fila = 0; fila < MAXF; fila++) {
			imprimir_arreglo(mat[fila]);
		}
	}

	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAXC; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}

}
