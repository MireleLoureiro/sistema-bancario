import java.util.*;

public class Banco {
    private List<ContaBancaria> contaBancarias = new ArrayList<>();
    private Map<String, ContaBancaria> mapContas = new HashMap<>();

    public void cadastrarConta(String cpf, ContaBancaria conta) {
        if (mapContas.containsKey(cpf)) throw new IllegalArgumentException("Já existe conta cadastrada para este CPF");
        this.contaBancarias.add(conta);
        this.mapContas.put(cpf, conta);
    }

    public ContaBancaria buscarPorCPF(String cpf) {
        if (cpf == null || cpf.isBlank()) throw  new IllegalArgumentException("CPF inválido.");
        ContaBancaria conta = mapContas.get(cpf);
        if (conta == null) throw new IllegalArgumentException("Conta não encontrada para o CPF: " + cpf);
        return conta;
    }

    public void listarContas() {
        for (ContaBancaria conta : contaBancarias) {
            System.out.println(conta);
            System.out.println();
        }
    }

    public Set<String> getTitulares() {
        Set<String> titulares = new HashSet<>();
        for (ContaBancaria conta : contaBancarias) {
            titulares.add(conta.getTitular());
        }
        return titulares;
    }

    public List<ContaBancaria> contasComSaldoAcimaDe(double valor) {
        return this.contaBancarias.stream()
                .filter(conta -> conta.getSaldo() > valor)
                .toList();
    }

    public double saldoTotal() {
        return this.contaBancarias.stream()
                .mapToDouble(ContaBancaria:: getSaldo)
                .sum();
    }

    public Optional<ContaBancaria> contaComMaiorSaldo() {
        return this.contaBancarias.stream()
                .max(Comparator.comparingDouble(ContaBancaria::getSaldo));
    }

    public List<String> nomesOrdenados() {
        return this.contaBancarias.stream()
                .sorted(Comparator.comparing(ContaBancaria::getTitular))
                .map(ContaBancaria::getTitular)
                .toList();
    }
}
