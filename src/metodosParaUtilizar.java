
//PARA ALEATORIO O RANDOM INCORPORAR LA LIBRERIA QUE SIGUE
import java.util.Random;

public class metodosParaUtilizar {
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static final double PROBABILIDAD_NUMERO = 0.4;
	public static final double PROBABILIDAD_LETRA = 0.4;

	public static void main(String[] args) {
		char[] arrchar;
		int[] arrint;
		double[] arrdouble;
		arrchar = new char[MAX];
		arrint = new int[MAX];
		arrdouble = new double[MAX];
		cargar_arreglo_aleatorio_char(arrchar);
		cargar_arreglo_aleatorio_int(arrint);
		cargar_arreglo_aleatorio_double(arrdouble);
		imprimir_arreglo_char(arrchar);
		imprimir_arreglo_int(arrint);
		imprimir_arreglo_double(arrdouble);
		// secuencias
		cargar_arreglo_aleatorio_secuencias_char(arrchar);
		imprimir_arreglo_secuencias_char(arrchar);
		cargar_arreglo_aleatorio_secuencias_int(arrint);
		imprimir_arreglo_secuencias_int(arrint);
	}

//carga de arreglo de char con valores de 'a' a la 'z'
	public static void cargar_arreglo_aleatorio_char(char[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (char) (r.nextInt(26) + 'a');
		}
	}

//carga de arreglo de int con valores de MINVALOR a MAXVALOR
	public static void cargar_arreglo_aleatorio_int(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

//carga de arreglo de double con valores de MINVALOR a MAXVALOR
	public static void cargar_arreglo_aleatorio_double(double[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = ((MAXVALOR - MINVALOR + 1) * r.nextDouble() + MINVALOR * 1.0);
		}
	}

//impresion de arreglo de char
	public static void imprimir_arreglo_char(char[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}

//impresion de arreglo de int
	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}

//impresion de arreglo de double
	public static void imprimir_arreglo_double(double[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}

	// cargar arreglo aleatorio de secuencia char
	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[MAX - 1] = ' ';
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > PROBABILIDAD_LETRA) {
				arr[pos] = (char) (r.nextInt(26) + 'a');
			} else {
				arr[pos] = ' ';
			}
		}
	}

	public static void imprimir_arreglo_secuencias_char(char[] arr) {
		System.out.print("Arreglo de secuencias char\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}

	// cargar arreglo aleatorio de secuencia int
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

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}

//ordenar por seleccion
	public static void ordenar_arreglo_seleccion(int[] arr) {
		int pos_menor, tmp;
		for (int i = 0; i < MAX; i++) {
			pos_menor = i;
			for (int j = i + 1; j < MAX; j++) {
				if (arr[j] < arr[pos_menor]) {
					pos_menor = j;

				}
			}
			if (pos_menor != i) {
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
		}
	}

//ordenamiento por insercion
	public static void ordenar_arreglo_insercion(int[] arr) {
		int aux, j;
		for (int i = 1; i < MAX; i++) {
			aux = arr[i];
			j = i - 1;
			while ((j >= 0) && (arr[j] > aux)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = aux;
		}
	}

//ordenamiento por burbujeo
	public static void ordenar_arreglo_burbujeo(int[] arr) {
		int temp;
		for (int i = 1; i < MAX; i++) {
			for (int j = 0; j < MAX - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
	}
}