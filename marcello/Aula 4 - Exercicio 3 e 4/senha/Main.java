package senha;

public class Main {


    public static void main(String[] args) {

        try {
            SenhaFraca senhaFraca = new SenhaFraca("teste");
            SenhaMedia senhaMedia = new SenhaMedia("Teste10");
            SenhaForte senhaForte = new SenhaForte("T&ste10s");
            SenhaForte senhaForteQueQuebra = new SenhaForte("Teste10");
        } catch (SenhaFracaException e) {
            throw new RuntimeException("Programa falhou com a seguinte mensagem: ",e);
        }

    }

}
