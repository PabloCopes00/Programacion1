
import java.util.Random;
/*
recu tema 2
 */

public class practicaMatricesTema2RECU {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 400;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int matint[][] = new int[MAXFILA][MAXCOLUMNA];
		int arrint[] = { 0, 3, 4, -1, -1 };

		cargar_matriz_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("");
		imprimir_arreglo(arrint);
		eliminarAlmenos3ImpMatrz(matint, arrint);
		System.out.println("");
		imprimir_matriz_int(matint);
	}

	public static void eliminarAlmenos3ImpMatrz(int[][] mat, int[] arr) {
		int fila;
		int i = 0;
		while ((i < MAXFILA) && (arr[i] != -1)) {
			fila = arr[i];
			analizarFilaMatriz(mat[fila]);
			i++;
		}

	}

	public static void analizarFilaMatriz(int[] mat) {
		int inicio = MAXCOLUMNA;
		int i = MAXCOLUMNA - 1;
		int fin;
		int j = inicio;
		int contadorImp = 0;

		int contador = 0;
		boolean termino = false;

		while ((i > 0) && !termino) {
			fin = buscarFin(mat, inicio - 1);
			
				inicio = buscarInicio(mat, fin);
				if (fin - inicio + 1 >= 3) {
					while (j <= fin) {
						if (mat[j] % 2 != 0) {
							System.out.println("el numero impar q estamos analizando es " + mat[j]);
							contadorImp++;

							if (contadorImp == 3) {
								contador++;

								if (contador == 2 || contador == 3) {
									corrimientoIzq(mat, inicio);
									contador++;
									System.out.println("elimine");
									if (contador == 2) {
										termino = true;
									}
								}
							}
						}
						j++;
					}
				}
			
			i--;
		}
	}

	public static void corrimientoIzq(int[] arr, int inicio) {
		for (int i = inicio; i < MAXCOLUMNA - 1; i++) {
			arr[i] = arr[i + 1];
		}

	}

	public static int buscarInicio(int[] arr, int pos) {
		while ((pos > 0) && (arr[pos] != 0)) {
			pos--;
		}
		return pos + 1;
	}

	public static int buscarFin(int[] arr, int pos) {
		while ((pos > 0) && (arr[pos] == 0)) {
			pos--;
		}
		return pos;
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
