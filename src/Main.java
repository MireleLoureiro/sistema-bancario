import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        try {
            banco.cadastrarConta("70955444411", new ContaCorrente("Mirele Loureiro", 2000.0, 550.0));
            banco.cadastrarConta("12802393448", new ContaPoupanca("Matheus Gonçalves", 6000.0));
            banco.cadastrarConta("28583400482", new ContaCorrente("Maria Pereira", 5000.0, 3500.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        List<ContaBancaria> contasComSaldoAcima = banco.contasComSaldoAcimaDe(4000.0);
        contasComSaldoAcima.forEach(System.out::println);
        System.out.println();
        System.out.println("Saldo total das contas: R$ " + String.format("%.2f", banco.saldoTotal()));

        Optional<ContaBancaria> contaMaiorSaldo = banco.contaComMaiorSaldo();
        contaMaiorSaldo.ifPresentOrElse(
                conta -> System.out.println("\nConta com maior saldo:\n" + conta),
                () -> System.out.println("Nenhuma conta encontrada.")
        );

        System.out.println(banco.nomesOrdenados());

    }
}
