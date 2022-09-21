import java.util.Random;

/*Hacer un programa que dado el arreglo definido y precargado elimine del arreglo
todas las ocurrencias de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). Al eliminar se pierden valores haciendo
corrimientos.*/
public class practica_arreglos_15 {
	public static final int MAX = 800;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD = 0.4;

	public static void main(String[] args) {
		int[] arreglo = new int[MAX];
		int[] patron = new int[2];
		cargarSecuencias(arreglo);
		System.out.println("Arreglo inicial");
		imprimirArreglo(arreglo);
		cargar_arreglo(patron);
		System.out.println("Arreglo patron");
		imprimirArreglo(patron);
		eliminarSecPatron(arreglo, patron);
		imprimirArreglo(arreglo);
	}
	public static void eliminarSecPatron(int arre[], int patron[]) {
		int inip = buscarInicio(patron, 0);
		int finp = buscarFin(patron, inip);
		eliminarSecuencias(arre, patron, inip, finp);
	}

	public static void eliminarSecuencias(int[] arre, int[] patron, int inip, int finp) {
		int inicio = 0;
		int fin = -1;
		while (inicio < MAX) {
			inicio = buscarInicio(arre, fin + 1);
			if (inicio < MAX) {
				fin = buscarFin(arre, inicio);
				if (esIgual(arre, inicio, fin, inip, finp)) {
					eliminarSecuencia(arre, patron, inicio, fin, inip, finp);
					inicio = fin + 1;
				}
			}
		}

	}

	public static void eliminarSecuencia(int[] arre, int patron[], int inicio, int fin, int inip, int finp) {
		if (arre[inicio] == patron[inip]) {
			if (arre[fin] == patron[finp]) {
				corrimientoIzquierda(arre, inicio, fin);
				System.out.println("Se eliminaron todas las secuencias del arreglo");
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

	public static boolean esIgual(int arre[], int inicio, int fin, int inip, int finp) {
		if ((fin - inicio + 1) == (finp - inip + 1)) {

			return true;
		}

		return false;
	}

	public static int buscarFin(int[] arreA, int i) {
		while ((i < arreA.length) && (arreA[i] != 0)) {
			i++;
		}
		return i - 1;
	}

	public static int buscarInicio(int[] arreA, int i) {
		while ((i < arreA.length) && (arreA[i] == 0)) {
			i++;
		}
		return i;
	}

	public static void cargarSecuencias(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimirArreglo(int[] arr) {
		for (int pos = 0; pos < arr.length; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}

	public static void cargar_arreglo(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < arr.length; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}
}