public class ContaCorrente extends ContaBancaria implements Transferivel{
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.getSaldo() + this.limite) {
            setSaldo(this.getSaldo() - valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    @Override
    public void transferir(ContaBancaria destino, double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public String toString() {
        return super.toString() + "Limite: R$ "
                + String.format("%.2f", this.limite);
    }
}
