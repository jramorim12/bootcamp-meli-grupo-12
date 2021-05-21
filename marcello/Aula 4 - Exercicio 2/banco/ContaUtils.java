package banco;

public interface ContaUtils {

    void deposito(ContaCorrente conta, double valor);

    void saque (ContaCorrente conta, double valor);

    void transferencia(ContaCorrente de, double valor, ContaCorrente para);

}
