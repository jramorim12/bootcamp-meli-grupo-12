package banco;

public class ContaCorrente {

    Double saldo;

    public ContaCorrente(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Saldo atual: " + this.saldo;
    }
}
