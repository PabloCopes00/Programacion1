import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/*Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, copie de forma continua las secuencias de tamaño igual al
número ingresado en otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio del mismo.*/

public class practica_arregos_14 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD_NUMERO = 0.4;

	public static void main(String[] args) {
		int arregloA[] = new int[MAX];
		int arregloB[] = new int[MAX];
		cargarSecuenciasInt(arregloA);
		System.out.println("\t\t\tArreglo A");
		imprimirArreglo(arregloA);
		System.out.println("\t\t\tArreglo B");
		imprimirArreglo(arregloB);
		copiarSecuenciasDeAenB(arregloA, arregloB);
		System.out.println("\nSe copiaron las siguientes secuencias.\n");
		imprimirArreglo(arregloB);

	}

	public static void copiarSecuenciasDeAenB(int[] arreA, int[] arreB) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num;
		int inicio = 0;
		int fin = -1;
		try {
			System.out.println("ingrese un numero para copiar las secuencias con ese tamanio.");
			num = Integer.valueOf(entrada.readLine());
			while (inicio < MAX) {
				inicio = buscarInicio(arreA, fin + 1);
				if (inicio < MAX) {
					fin = buscarFin(arreA, inicio);
					if (esIgual(inicio, fin, num)) {
						copiarSecuencias(arreA, arreB, inicio, fin);
					}
				}
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void copiarSecuencias(int arreA[], int arreB[], int ini, int fin) {
		int inicio = ini;
		int i = 0;

		while (inicio <= fin) {
			while (arreB[i] == 0) {
				arreB[i] = arreA[inicio];
				inicio++;

			}
			i++;
		}

	}

	public static boolean esIgual(int ini, int fin, int num) {
		if ((fin - ini + 1) == num) {
			return true;
		}

		return false;
	}

	public static int buscarFin(int[] arreA, int i) {
		while ((i < MAX) && (arreA[i] != 0)) {
			i++;
		}
		return i - 1;
	}

	public static int buscarInicio(int[] arreA, int i) {
		while ((i < MAX) && (arreA[i] == 0)) {
			i++;
		}
		return i;
	}

	public static void cargarSecuenciasInt(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD_NUMERO) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
}
