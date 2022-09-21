import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.
 */
public class practicaArreglos13 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD_NUMERO = 0.4;

	public static void main(String[] args) {
		int arreglo[] = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arreglo);
		imprimirArreglo(arreglo);
		eliminarSecuenciasTamanioIgualNro(arreglo);
	}

	public static void eliminarSecuenciasTamanioIgualNro(int[] arreglo) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num;
		try {
			System.out.println("ingrese un numero para eliminar las secuencias con ese tamanio.");
			num = Integer.valueOf(entrada.readLine());
			buscarSecuencias(arreglo, num);
			imprimirArreglo(arreglo);
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	private static void buscarSecuencias(int[] arreglo, int num) {
		int inicio = 0;
		int fin = -1;
		while (inicio < MAX) {
			inicio = buscarInicio(arreglo, fin + 1);
			if (inicio < MAX) {
				fin = buscarFin(arreglo, inicio);
				if (sonIguales(inicio, fin, num)) {
					corrimientoIzquierda(arreglo, inicio, fin);
					inicio = fin + 1;
				}
			}
		}

	}

	public static void corrimientoIzquierda(int[] arreglo, int inicio, int fin) {
		int start = inicio;
		while (start <= fin) {
			for (int i = inicio; i < MAX - 1; i++) {
				arreglo[i] = arreglo[i + 1];
			}
			start++;
		}
	}

	public static boolean sonIguales(int inicio, int fin, int num) {
		if (((fin - inicio) + 1) == num) {
			return true;

		}
		return false;
	}

	public static int buscarFin(int[] arreglo, int i) {
		while ((i < MAX) && (arreglo[i] != 0)) {
			i++;
		}
		return i - 1;
	}

	public static int buscarInicio(int[] arreglo, int i) {
		while ((i < MAX) && (arreglo[i] == 0)) {
			i++;
		}
		return i;
	}

	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
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
