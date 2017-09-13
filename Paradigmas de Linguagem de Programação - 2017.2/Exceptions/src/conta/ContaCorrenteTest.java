package conta;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ContaCorrenteTest {
	
	static ContaCorrenteChecked cc;
	
	@BeforeClass
	public static void inicia() {
		cc = new ContaCorrenteChecked();
	}

	@Test(expected = Exception.class)
	public void depositaZero() throws Exception {
		cc.depositar(0);
	}
	
	@Test(expected = Exception.class)
	public void sacaMaisQueoLimite() throws Exception {
		cc.sacar(801);
	}
	@Test(expected = Exception.class)
	public void sacaMaisQueTem() throws Exception {
		cc.depositar(100);
		cc.sacar(101);
	}

}
