package temperatura;

public class Utils {

	public static double toCelcius(double f) throws FahrenheitException {
		double valor =  (5 * (f-32)) / 9;
		
		if (valor < 459.67) {
			throw new FahrenheitException();
		}
		
		return valor;
		
	}
	
}
