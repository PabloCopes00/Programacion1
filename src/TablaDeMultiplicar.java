
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TablaDeMultiplicar {
	
	public static final int MIN = 1;
	public static final int MAXMULTIPLICADOR = 10;
	
	public static void main(String[] args) {
		
	int numero_natural;
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	
	try{

	System.out.println("Ingrese un numero natural");
	numero_natural = Integer.valueOf(entrada.readLine());
	if (numero_natural >= MIN){
	imprimir_tabla_de_multiplicar (numero_natural);
	}

	}
	catch (Exception exc){

	System.out.println(exc);

	}
	}
	public static void imprimir_tabla_de_multiplicar (int numero){
	for (int multiplicador = 1; multiplicador <= MAXMULTIPLICADOR; multiplicador++){
	System.out.println(numero + " * " + multiplicador + " = " + (numero * multiplicador));
	}
	}
	
}
