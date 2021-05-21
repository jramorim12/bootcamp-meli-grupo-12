package banco;

public class Banco {

    private static ContaUtils contaUtilsImpl = new ContaUtilsImpl();

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(1500.);
        ContaCorrente conta2 = new ContaCorrente(2000.);
        Banco.contaUtilsImpl.deposito(conta1, 1000.);
        Banco.contaUtilsImpl.saque(conta2, 500.);
        Banco.contaUtilsImpl.transferencia(conta1,1000,conta2);
    }

}
