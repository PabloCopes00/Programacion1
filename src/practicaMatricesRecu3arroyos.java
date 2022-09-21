
import java.util.Random;

public class practicaMatricesRecu3arroyos {
	public static final int MAXVALUE = 9;
	public static final int MINVALUE = 1;
	public static final int MAXF = 4;
	public static final int MAXC = 20;
	public static final double PROB = 0.4;

	public static void main(String[] args) {
		int[][] matriz = new int[MAXF][MAXC];
		cargarMatriz(matriz);
		imprimirMatriz(matriz);
		obtenerPosicionesSecuencias(matriz);
		imprimirMatriz(matriz);
	}

	public static void cargarMatriz(int[][] matriz) {
		Random r = new Random();
		for (int fila = 0; fila < MAXF; fila++) {
			matriz[fila][0] = 0;
			matriz[fila][MAXC - 1] = 0;
			for (int col = 1; col < MAXC - 2; col++) {
				if (PROB < r.nextDouble()) {
					matriz[fila][col] = (r.nextInt(MAXVALUE - MINVALUE + 1) + MINVALUE);
				}
			}
		}
	}

	
	public static void imprimirMatriz(int[][] matriz) {
		for(int fila = 0; fila < MAXF; fila++) {
			for(int col = 0; col < MAXC-1; col++) {
				System.out.print("[" + matriz[fila][col] + "]");
			}
			System.out.print("\n");
		}
	}
	
	

	public static void obtenerPosicionesSecuencias(int[][] matriz) {
		int elemElimTotales = 0;
		for (int fila = 0; fila < MAXF; fila++) {
			int posini = 0;
			int posfin = 0;
			int posini2 = 0;
			int posfin2 = 0;
			int pos = 0;
			int sumaTotal = 0;
			while (pos < MAXC - 1) {
				int elemElim = 0;
				posini = obtenerPosIni(matriz, fila, pos);
				posfin = obtenerPosFin(matriz, fila, posini);
				elemElim = analizarSec(matriz, fila, posini, posfin);
				pos = posfin + 1 - elemElim;
				if (elemElim == 0) {
					int suma = 0;
					suma = obtenerSumatoria(matriz, fila, posini, posfin);
					if (suma > sumaTotal) {
						sumaTotal = suma;
						posini2 = posini;
						posfin2 = posfin;
					}
				}
				elemElimTotales += elemElim;
			}
			invertirSec(matriz, fila, posini2, posfin2);
		}
		System.out.println("La cantidad de elementos eliminados es: " + elemElimTotales);
	}

	public static int obtenerPosIni(int[][] matriz, int fila, int pos) {
		while ((pos < MAXC - 1) && (matriz[fila][pos] == 0)) {
			pos++;
		}
		return pos;
	}

	public static int obtenerPosFin(int[][] matriz, int fila, int pos) {
		while (matriz[fila][pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int analizarSec(int[][] matriz, int fila, int posini, int posfin) {
		int contador = 0;
		int pos = posini;
		int cantidad = 0;
		while ((pos <= posfin) && (contador < 5)) {
			if ((matriz[fila][pos] % 2 != 0) || (matriz[fila][pos] % 7 == 0)) {
				corrimientoIzq(matriz, fila, pos);
				posfin--;
				cantidad++;
				contador++;
			} else {
				pos++;
			}
		}
		return cantidad;
	}

	public static int obtenerSumatoria(int[][] matriz, int fila, int posini, int posfin) {
		int suma = 0;
		while (posini <= posfin) {
			suma += matriz[fila][posini];
			posini++;
		}
		return suma;
	}

	public static void corrimientoIzq(int[][] matriz, int fila, int posini) {
		while (posini < MAXC - 2) {
			matriz[fila][posini] = matriz[fila][posini + 1];
			posini++;
		}
	}

	public static void invertirSec(int[][] matriz, int fila, int posini, int posfin) {
		int temp = 0;
		for (int i = posini; i < posfin; i++) {
			temp = matriz[fila][i];
			matriz[fila][i] = matriz[fila][posfin];
			matriz[fila][posfin] = temp;
			posfin--;
		}
	}
}
