import java.util.Random;

/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre
sus elementos.
*/
public class practicaMatrices15 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 20;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		char matchar[][] = new char[MAXFILA][MAXCOLUMNA];

		cargarMatSecuenciasChar(matchar);
		imprimirMatChar(matchar);
		eliminarSecOrdenDescendienteMatriz(matchar);
		System.out.println("\neliminamos de la matriz las secuencias descendentes y quedo de la siguiente manera:\n");
		imprimirMatChar(matchar);
	}

	public static void eliminarSecOrdenDescendienteMatriz(char[][] mat) {
		for (int i = 0; i < MAXFILA; i++) {
			eliminarSecOrdenDescendente(mat[i]);
		}
	}

	public static void eliminarSecOrdenDescendente(char[] arr) {
		int inicio = 0;
		int fin = -1;
		boolean descendente = false;
		int j = 0;
		while (j < MAXCOLUMNA) {
			inicio = buscarInicio(arr, fin + 1);
			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(arr, inicio);
				descendente = analizarSecDescendente(arr, inicio, fin);
				if (descendente) {
					for (int i = inicio; i <= fin; i++) {
						corrimientoIzquierda(arr, inicio);
					}
				}
			}

			j++;
		}
	}

	public static boolean analizarSecDescendente(char[] arr, int inicio, int fin) {
		int j = inicio;
		boolean descendente = true;
		if((fin-inicio+1)>=2){
		while ((j < fin) && descendente) {
			if (arr[j] >= arr[j + 1]) {
				j++;
			} else {
				descendente = false;
			}
		}
		}else {descendente = false;}

		return descendente;
	}

	public static void corrimientoIzquierda(char[] arr, int inicio) {
		for (int i = inicio; i < MAXCOLUMNA - 1; i++) {
			arr[i] = arr[i + 1];
		}

	}

	public static int buscarFin(char[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != ' ')) {
			inicio++;
		}

		return inicio - 1;
	}

	public static int buscarInicio(char[] matint, int i) {
		while ((i < MAXCOLUMNA) && (matint[i] == ' ')) {
			i++;
		}
		return i;
	}

	public static void cargarArregloEspacios(char[] patron) {
		for (int i = 0; i < MAXCOLUMNA - 1; i++) {
			patron[i] = ' ';
		}
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
