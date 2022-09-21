import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 Hacer un programa que dada la matriz de secuencias de enteros definida
y precargada, permita obtener a través de métodos la posición de inicio y
la posición de fin de la secuencia ubicada a partir de una posición entera
y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
por pantalla ambas posiciones obtenidas.  
 */

public class practicaMatrices10 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int fila, col;
		cargar_matriz_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("inserte un numero de fila");
		fila = pedirIntUsuario();
		System.out.println("inserte un numero de columna");
		col = pedirIntUsuario();
		obtenerInicioYfin(matint[fila], col);

	}

	public static void obtenerInicioYfin(int[] arr, int pos) {
		int inicio, fin;
		if(arr[pos] == 0) {
			System.out.println("En esta posicion no hay ninguna secuencia.");
			
		}else {
			inicio = buscarInicio(arr, pos);
			fin = buscarFin(arr, pos);
			System.out.println("La secuencia comienza en " + inicio + " y termina en " + fin);
		}
	}

	public static int buscarFin(int[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != 0)) {
			inicio++;
		}

		return inicio - 1;
	}

	public static int buscarInicio(int[] matint, int i) {
		while ((i > 0) && (matint[i] != 0)) {
			i--;
		}
		return i + 1;
	}

	public static int pedirIntUsuario() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return num;
	}

	public static void cargar_matriz_secuencias_int(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo_secuencias_int(mat[fila]);
		}
		System.out.println(" ");
	}

	public static void cargar_arreglo_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA - 1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimir_matriz_int(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo_int(mat[fila]);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
