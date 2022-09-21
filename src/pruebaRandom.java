import java.util.Random;

public class pruebaRandom {
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final int MAX = 10;

	public static void main(String[] args) {
		int arreglo [] = new int [MAX];
		cargar_arreglo(arreglo);
		imprimir_arreglo(arreglo);

	}

	public static void cargar_arreglo(int[] arr) {
		Random r = new Random();
		for (int i = 0; i < MAX; i++) {
			arr[i] = (r.nextInt(MAXVALOR) + MINVALOR);
		}

	}
	public static void imprimir_arreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("[" + arr[pos] + "]");
		}
		System.out.println("");
	}
	
}
