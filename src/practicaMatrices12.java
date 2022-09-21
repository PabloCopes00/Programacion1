import java.util.Random;

/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, permita encontrar por cada fila la posición de inicio y fin de la
anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
posición de la fila).
*/
public class practicaMatrices12 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		char matchar[][] = new char[MAXFILA][MAXCOLUMNA];
		cargarMatSecuenciasChar(matchar);
		imprimirMatChar(matchar);
		eliminarAnteUltimaSecMat(matchar);
		System.out.println("\nEliminamos la ante ultima secuencia de cada fila y asi quedo la matriz:\n");
		imprimirMatChar(matchar);
	}

	public static void eliminarAnteUltimaSecMat(char[][] mat) {
		for (int i = 0; i < MAXFILA; i++) {
			eliminarAnteUltimaSec(mat[i]);
		}

	}

	public static void eliminarAnteUltimaSec(char[] arr) {
		int contador = 0;
		int i = MAXCOLUMNA - 1;
		int inicio = MAXCOLUMNA;
		int fin = 0;
		boolean encontrado = false;

		while ((i > 0) && !encontrado) {
			fin = buscarFin(arr, inicio - 1);
			if (fin > 0) {
				inicio = buscarInicio(arr, fin);
			}
			contador++;
			if (contador == 2) {
				for (int j = inicio; j <= fin; j++) {
					corrimientoIzquierda(arr, inicio);
				}
				encontrado = true;
				System.out.println("El inicio de la ante ultima secuencia es en la posicion" + inicio
						+ " y el fin es en la posicion " + fin);
			}
			i--;
		}
	}

	public static void corrimientoIzquierda(char[] arr, int inicio) {
		for (int i = inicio; i < MAXCOLUMNA - 1; i++) {
			arr[i] = arr[i + 1];
		}

	}

	public static int buscarInicio(char[] arr, int pos) {
		while ((pos > 0) && (arr[pos] != ' ')) {
			pos--;
		}
		return pos + 1;
	}

	public static int buscarFin(char[] arr, int pos) {
		while ((pos > 0) && (arr[pos] == ' ')) {
			pos--;
		}
		return pos;
	}

	public static void cargarMatSecuenciasChar(char[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			cargar_arreglo_secuencias_char(mat[fila]);
		}
		System.out.println(" ");
	}

	public static void cargar_arreglo_secuencias_char(char[] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXCOLUMNA - 1] = ' ';
		for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD) {
				arr[pos] = (char) (r.nextInt(26) + 'a');
			} else {
				arr[pos] = ' ';
			}
		}
	}

	public static void imprimirMatChar(char[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo_char(mat[fila]);
		}
	}

	public static void imprimir_arreglo_char(char[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
