package banco;

public class ContaUtilsImpl implements ContaUtils{

    @Override
    public void deposito(ContaCorrente conta, double valor) {
        conta.setSaldo((conta.getSaldo() + valor));
        System.out.println(conta);
    }

    @Override
    public void saque(ContaCorrente conta, double valor) {
        conta.setSaldo((conta.getSaldo() - valor));
        System.out.println(conta);
    }

    @Override
    public void transferencia(ContaCorrente de, double valor, ContaCorrente para) {
        this.saque(de, valor);
        this.deposito(para, valor);
    }
}
