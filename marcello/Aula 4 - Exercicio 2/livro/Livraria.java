package livro;

public class Livraria {

    public static void main(String[] args) {
        LivrariaUtils livrariaUtils = new LivrariaUtils();
        Livro harryPotter = new Livro("Harry Potter", "J. K. Rowling", 1997, null);
        Cliente joao = new Cliente("João");
        Cliente maria = new Cliente("Maria");

        livrariaUtils.devolucao(harryPotter);
        livrariaUtils.emprestimo(harryPotter, joao);
        livrariaUtils.devolucao(harryPotter);
        livrariaUtils.emprestimo(harryPotter, maria);

    }

}
