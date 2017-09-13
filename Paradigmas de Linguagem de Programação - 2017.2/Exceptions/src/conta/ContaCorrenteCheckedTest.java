package conta;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContaCorrenteCheckedTest {
	
	static ContaCorrente cc;
	
	@BeforeClass
	public static void inicia() {
		cc = new ContaCorrente();
	}

	@Test(expected = IllegalArgumentException.class)
	public void depositaZero() {
		cc.depositar(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sacaMaisQueoLimite() throws SaldoInsuficienteExcecao {
		cc.sacar(801);
	}
	@Test(expected = SaldoInsuficienteExcecao.class)
	public void sacaMaisQueTem() throws SaldoInsuficienteExcecao {
		cc.depositar(100);
		cc.sacar(101);
	}

}
