public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    public void renderJuros(double taxa) {
        setSaldo(getSaldo() * (1 + taxa));
    }
}
