public class ContaCorrente {
    private double saldo;
    private String cliente;
    private int id;

    public ContaCorrente(double saldo, String cliente, int ID) {
        this.saldo = saldo;
        this.cliente = cliente;
        this.id = ID;
    }

    public ContaCorrente(ContaCorrente conta) {
        this.saldo = conta.getSaldo();
        this.cliente = conta.getCliente();
        this.id = conta.getID();
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void transferir(double valor, ContaCorrente contaOrigem, ContaCorrente contaDestino){
        contaDestino.sacar(valor);
        contaOrigem.depositar(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        cliente = cliente;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }
}
