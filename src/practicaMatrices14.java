import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, elimine de cada fila todas las ocurrencias de una secuencia
patrón dada por un arreglo de caracteres de tamaño igual al tamaño de
columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al
final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.
*/
public class practicaMatrices14 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 30;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		char matchar[][] = new char[MAXFILA][MAXCOLUMNA];
		char patron[] = new char[MAXCOLUMNA];
		cargarMatSecuenciasChar(matchar);
		imprimirMatChar(matchar);
		cargarArregloEspacios(patron);
		System.out.println("\nIngrese un caracter");
		patron[3] = pedirCharUsuario();
		System.out.println("\nIngrese un caracter");
		patron[4] = pedirCharUsuario();
		System.out.println("\nIngrese un caracter");
		patron[5] = pedirCharUsuario();
		imprimir_arreglo_char(patron);
		eliminarSecPatronMatriz(matchar, patron);
		System.out.println("\nEliminando Patron...\nLa matriz quedo de la siguiente manera.\n");
		imprimirMatChar(matchar);
	}

	public static void eliminarSecPatronMatriz(char[][] matchar, char[] patron) {
		for (int i = 0; i < MAXFILA; i++) {
			eliminarSecPatron(matchar[i], patron);
		}
	}

	public static void eliminarSecPatron(char[] arr, char[] patron) {
		int j = 0;
		int inicio = 0;
		int fin = -1;
		int inicioPat;
		int finPat;
		boolean esIgual;

		inicioPat = buscarInicio(patron, fin + 1);
		finPat = buscarFin(patron, inicioPat);

		while (j < MAXCOLUMNA) {
			inicio = buscarInicio(arr, fin + 1);
			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(arr, inicio);
				esIgual = analizarSecuencias(arr, patron, inicioPat, finPat, inicio, fin);
				if (esIgual) {
					for (int i = inicio; i <= fin; i++) {
						corrimientoIzquierda(arr, inicio);
					}

				}

			}

			j++;
		}

	}

	private static boolean analizarSecuencias(char[] arr, char[] patron, int inicioPat, int finPat, int inicio,
			int fin) {

		int i1 = inicio;
		int i2 = inicioPat;
		boolean igual = false;
		boolean distintos = false;

		if ((finPat - inicioPat + 1) == (fin - inicio + 1)) {
			while ((i1 <= fin) && !distintos) {

				if (arr[i1] == patron[i2]) {
					i1++;
					i2++;
					igual = true;
				} else {
					igual = false;
					distintos = true;
				}
			}
		}
		return igual;
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

	public static char pedirCharUsuario() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		char caracter = ' ';
		try {
			caracter = entrada.readLine().charAt(0);
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return caracter;
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
