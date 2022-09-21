import java.io.BufferedReader;
import java.io.InputStreamReader;
public class fase_lunar {

	public static void main(String[] args) {
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
		int anio, aureo, epacta, dia, mes, restMarzo, lunar, fase;
		try {
			System.out.println("Ingrese un dia en numeros");
			dia = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un mes en numeros");
			mes = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un anio en numeros");
			anio =Integer.valueOf(entrada.readLine());
			aureo = ((anio++)%19);
			epacta = (((aureo--)*11)%30);
			restMarzo = ((mes - 3 + 1)%12);
			lunar = (epacta + restMarzo + dia);
			if (lunar<= 29) {
				System.out.println("han pasado " + lunar + " dias desde la ultima luna nueva.");
				fase = (lunar/7);
			}
			else { 
				fase = ((lunar % 30)/7);
			}
			switch (fase){
			case 0:{
				System.out.println("hace 4 dias que comenzo la la fase: luna nueva");
				break;
				}
			case 1:{
				System.out.println("hace 4 dias que comenzo la la fase: creciente");
			}
			case 2:{
			System.out.println("hace 4 dias que comenzo la la fase: llena");
			}
			case 3: case 4:{
				System.out.println("hace 4 dias que comenzo la la fase: luna menguante");
			}
			}
		}
		catch (Exception exc){
			System.out.println(exc);
		}

	}

}
