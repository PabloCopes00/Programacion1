public class Prefinal_t2 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXCHAR = 4;

	public static void main(String[] args) {
		char[][] matriz = new char[MAXFILA][MAXCOLUMNA];
		char[] arreAux = new char[MAXCOLUMNA];

		cargar_matriz_aleatorio_char(matriz);
		imprimir_matriz_char(matriz);
		System.out.println(" ");

		cargar_arreglo_ordenado(arreAux);
		imprimir_arreglo_char(arreAux);
		System.out.println(" ");
		buscar_columnas_caracter_letra(matriz, arreAux);
	}

	public static void buscar_columnas_caracter_letra(char[][] matriz, char[] arre) {
		int contadorMenor = MAXFILA;
		int columnaMenor = 0;
		int columna = 0;
		int fila = 0;
		while ((columna < MAXCOLUMNA)&&(fila < MAXFILA))  {
			if ((matriz[fila][columna] != '0') && (matriz[fila][columna] != '1') && (matriz[fila][columna] != '2')
					&& (matriz[fila][columna] != '3') && (matriz[fila][columna] != '4')
					&& (matriz[fila][columna] != '5') && (matriz[fila][columna] != '6')
					&& (matriz[fila][columna] != '7') && (matriz[fila][columna] != '8')
					&& (matriz[fila][columna] != '9')) {		

				int contadorConsonantes = columna_menor_cant_conso_menores_m(matriz, columna);
				
				if (contadorConsonantes <= contadorMenor) {
					contadorMenor = contadorConsonantes;
					columnaMenor = columna;
				}
			}
			fila++;
			columna++;
		}

		System.out.println("La columna que tiene menor cantidad de caracteres consonantes menores a 'm' es: "
				+ columnaMenor + " y tiene " + contadorMenor + " consonantes");
		
		comparar_arreglo_con_columna(matriz, arre, columnaMenor);
	}

	public static int columna_menor_cant_conso_menores_m(char[][] matriz, int columna) {
		int fila = 0;
		int contador = 0;
		while (fila < MAXFILA) {
			if ((matriz[fila][columna] > 'a') && (matriz[fila][columna] < 'z')) {
				if ((matriz[fila][columna] != 'a') && (matriz[fila][columna] != 'e') && (matriz[fila][columna] != 'i')
						&& (matriz[fila][columna] != 'o') && (matriz[fila][columna] != 'u')) {
					if (matriz[fila][columna] < 'm') {
						contador++;
					}
				}
			}
			fila++;
		}
		return contador;
	}

	public static void comparar_arreglo_con_columna(char[][] matriz, char[] arre, int columna) {
		int fila = 0;		
		int contador = 0;
		while ((fila < MAXFILA) && (contador <= MAXCHAR)) {
			int pos = 0;
			while ((pos < MAXCOLUMNA)&& (matriz[fila][columna] >= arre[pos])){				 
					if (matriz[fila][columna] == arre[pos]) {
						System.out.println("Caracter encontrado " + matriz[fila][columna]);
						contador++;					
						}
					pos++;
				}
			fila++;
			}
			
		}
	
	public static void cargar_matriz_aleatorio_char(char[][] mat) {
		mat[0][0] = '2';
		mat[1][0] = '3';
		mat[2][0] = '9';
		mat[3][0] = '0';
		mat[0][1] = 'z';
		mat[1][1] = 'o';
		mat[2][1] = 'p';
		mat[3][1] = 'd';
		mat[0][2] = 'e';
		mat[1][2] = 'f';
		mat[2][2] = 'g';
		mat[3][2] = 'g';
		mat[0][3] = '2';
		mat[1][3] = '0';
		mat[2][3] = '1';
		mat[3][3] = '8';
		mat[0][4] = 'm';
		mat[1][4] = 'a';
		mat[2][4] = 'a';
		mat[3][4] = 'a';

	}

	public static void imprimir_matriz_char(char[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++) {
				System.out.print(mat[fila][columna] + "|");
			}
			System.out.println("");
		}
	}

	public static void cargar_arreglo_ordenado(char[] arre) {
		arre[0] = 'a';
		arre[1] = 'c';
		arre[2] = 'd';
		arre[3] = 'o';
		arre[4] = 'z';
	}

	public static void imprimir_arreglo_char(char[] arr) {
		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println(" ");

	}
}