package supermercado;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    public static void main(String[] args) {
        Produto produto1 = new Produto("Arroz", 10.99, 2);
        Produto produto2 = new Produto ("Feijão", 14.49, 1);
        Produto produto3 = new Produto("Tomate", 9.99, 5);

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);

        Lista.imprimeLista(listaProdutos);

    }
    

    private static void imprimeLista(List<Produto> listaProdutos) {

        for(Produto produto : listaProdutos) {
            System.out.println(produto.toString());
        }

        System.out.println("Valor total da compra: R$ " + Lista.getValorTotal(listaProdutos) );
    }

    private static double getValorTotal(List<Produto> listaProdutos) {
        double valorTotal = 0;

        for(Produto produto : listaProdutos) {
            valorTotal += (produto.getValor() * produto.getQuantidade());
        }

        return valorTotal;
    }

}
