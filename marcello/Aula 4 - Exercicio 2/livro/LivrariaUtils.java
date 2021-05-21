package livro;

public class LivrariaUtils {

    public void emprestimo(Livro livro, Cliente cliente) {
        if(livro.getCliente() == null){
            livro.setCliente(cliente);
            System.out.println("O livro " + livro.getNome() + " foi emprestado para o cliente " + cliente);
            return;
        }
        System.out.println("O cliente " + livro.getCliente() + " precisa devolver o livro para ser emprestado!");
    }

    public void devolucao(Livro livro) {
        if(livro.getCliente() == null) {
            System.out.println("O livro não está com nenhum cliente!!");
            return;
        }
        System.out.println("O cliente " + livro.getCliente() + " devolveu o livro " + livro.getNome());
        livro.setCliente(null);
    }

}
