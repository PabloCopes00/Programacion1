import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
y colocar el numero en la matriz en la posición fila, columna indicada.
*/

public class practicaMatrices4 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;

	public static void main(String[] args) {
		int matriz[][] = new int[MAXFILA][MAXCOLUMNA];
		int num, fil, col;
		cargar_matriz(matriz);
		imprimir_matriz(matriz);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("ingrese un numero de fila");
			fil = Integer.valueOf(entrada.readLine());
			System.out.println("ingrese un numero de columna");
			col = Integer.valueOf(entrada.readLine());
			System.out.println("ingrese un numero para insertar en esa posicion.");
			num = Integer.valueOf(entrada.readLine());
			corrimientoDerecha(matriz[fil], col, num);
			System.out.println("el numero " + num + " se inserto correctamente.");
			imprimir_matriz(matriz);
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void corrimientoDerecha(int mat[], int col, int num) {
		for (int i = MAXCOLUMNA - 1; i > col; i--) {
			mat[i] = mat[i - 1];
		}
		mat[col] = num;
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
