package precedenciaPessoa;

public class Main {

    // Para mudarmos o critério de precedência devemos alterar o metódo de cada Classe que implementa.
    // A solução não é muito sustentável, já que para cada Classe que criarmos que implmente o método precede().
    // Precisamos implementar o método adequado para a Classe.
    // Uma maneira de melhorar a sustentabilidade do Sorter é implementar um método padrão para precedência.
    // Assim todas as classes que implementarem a Interface terão esse método.
    // E para alterar o critério de precedência basta alterar um método, e não os respectivos métodos de cada classe.

    public static void main(String[] args) {
        Pessoa marcello = new Pessoa("Marcello", "00000000001");
        Pessoa joao = new Pessoa("João", "00000000002");
        Pessoa rodrigo = new Pessoa("Rodrigo", "00000000003");
        Pessoa gabriel = new Pessoa("Gabriel", "00000000004");
        Pessoa nicolas = new Pessoa("Nicolas", "11100000001");

        Pessoa[] array = {joao,gabriel,marcello,rodrigo,nicolas};

        SortUtil sortUtil = new SortUtil();

        sortUtil.sort(array);

        for(Pessoa pessoa : array) {
            System.out.println(pessoa);
        }
    }
}
