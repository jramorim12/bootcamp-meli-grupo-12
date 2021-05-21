package supermercado;

public class Produto {

    private String nomeProduto;
    private double valor;
    private int quantidade;

    public Produto(){};

    public Produto(String nomeProduto, double valor, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public double getValor(){
        return this.valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {

        return (this.nomeProduto + "\n" +
                "R$ " + this.valor + "\n" + 
                "Quantidade: " + this.quantidade) ;
    }

}