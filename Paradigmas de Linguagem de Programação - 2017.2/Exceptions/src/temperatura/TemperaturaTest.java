package temperatura;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TemperaturaTest {
	

	@Test(expected = FahrenheitException.class)
	public void menorQueOPermitido() throws FahrenheitException {
		Utils.toCelcius(789);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void calculaEmCelcius() throws Exception {
		assertEquals(555.55, Utils.toCelcius(1032), 0.05);
	}
	
}
