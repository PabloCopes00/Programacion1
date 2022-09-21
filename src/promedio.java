
public class promedio {
	public static final int MAX = 1000;
	public static final int MIN = 1;
	
	public static void main(String[] args) {
	int promedio;
	promedio = calcular_promedio_1_1000();
	System.out.println("El promedio de la suma entre " + MIN + " y " + MAX + " es " + promedio);
	}
	
	public static int calcular_promedio_1_1000() {
	int promedio;
	int suma = 0;
	for (int numero = MIN; numero <= MAX; numero++) {

	suma += numero;

	}
	promedio = suma/MAX;
    return promedio;
}
}

