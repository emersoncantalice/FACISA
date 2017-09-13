package conta;

public class ContaCorrenteChecked {

	private float limite;
	private float saldo;
	private float valorLimite = 800;

	public void sacar(float valor) throws Exception {
		if(valor <= 0) {
			throw new Exception("É necessario um valor de saque");
		}else if (valor > valorLimite) {
			throw new Exception("Valor solicitado maior que o disponivel para saque");
		} else if (valor > limite) {
			throw new Exception("Valor solicitado maior que o disponivel");
		}
		this.limite -= valor;
	}

	public void depositar(float valor) throws Exception {
		if(valor <= 0) {
			throw new Exception("É necessario algum valor de deposito");
		}
		this.limite += valor;
	}

	public void setValorLimite(float valorLimite) {
		this.valorLimite = valorLimite;
	}

}
