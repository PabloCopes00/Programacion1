import java.util.Random;
/*
Tema 1: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Se pide guardar en un arreglo los números de filas de las primeras 4 filas que cumplen con la condición de tener a lo sumo 5 secuencias sin orden ascendente.
Observaciones: _el tamaño arreglo es igual a la cantidad de filas de la matriz, y está inicializado con -1,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_realizar el programa completo sin realizar métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.

 */

public class practicaMatricesRecu1 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 40;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final int CANTFILAS = 4;
	public static final int CANTSEC = 5;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int arrAux[] = { -1, -1, -1, -1, -1 };
		cargar_matriz_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("");
		imprimir_arreglo(arrAux);
		procesarFilasAloSumo5Descendentes(matint, arrAux);
		System.out.println("\nEl arreglo quedo de la siguiente manera.\n");
		imprimir_arreglo(arrAux);
	}

	private static void procesarFilasAloSumo5Descendentes(int[][] matint, int[] arrAux) {
		int i = 0;
		int contFilas = 0;
		int contador = 0;
		boolean termino = false;
		while (i < MAXFILA && !termino) {
			contFilas = procesarFila(matint[i], arrAux, i);
			i++; 
			contador += contFilas;
			if(contador > CANTFILAS) {
				termino = true;
			}
		}
		if(contador == 0) {
			System.out.println("No se copio ningun Indice de Fila porque todas las filas tienen mas de 5 sec ");
		}
	}

	public static int procesarFila(int[] matarr, int arrAux[], int indice) {
		int i = 0;
		int inicio = 0;
		int fin = -1;
		int cantDescendentes = 0;
		int cantFilas = 0;
		boolean descendente = false;

		while ((i < MAXCOLUMNA) && (cantDescendentes <= CANTSEC)) {
			inicio = buscarInicio(matarr, fin + 1);
			if (inicio < MAXCOLUMNA) {
				fin = buscarFin(matarr, inicio);
				descendente = analizarSecDescendente(matarr, inicio, fin);
				if (descendente) {
					if (descendente) {
						cantDescendentes++;
					}

				}
			}
			i++;
		}
		if (cantDescendentes <= CANTSEC) {
			copiarFilaEnArregloAux(arrAux, indice);
			cantFilas++;
		}
		return cantFilas;
	}

	public static void copiarFilaEnArregloAux(int[] arrAux, int indice) {
		int i = 0;
		boolean termino = false;
		while (i < MAXFILA && !termino) {
			if (arrAux[i] == -1) {
				arrAux[i] = indice;
				termino = true;
			}
			i++;
		}
		System.out.println("Copiamos la fila " + indice + " al Arreglo.");

	}

	public static boolean analizarSecDescendente(int[] arr, int inicio, int fin) {
		int j = inicio;
		boolean descendente = true;

		while ((j <= fin) && descendente) {
			if (arr[j] >= arr[j + 1]) {
				j++;
			} else {
				descendente = false;
			}
		}

		return descendente;
	}

	public static int buscarFin(int[] matint, int inicio) {
		while ((inicio < MAXCOLUMNA) && (matint[inicio] != 0)) {
			inicio++;
		}

		return inicio - 1;
	}

	public static int buscarInicio(int[] matint, int i) {
		while ((i < MAXCOLUMNA) && (matint[i] == 0)) {
			i++;
		}
		return i;
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

	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAXFILA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
