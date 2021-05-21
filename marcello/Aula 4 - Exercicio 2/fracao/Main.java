package fracao;

public class Main {

    public static void main(String[] args) {
        FracaoUtils fracaoUtils = new FracaoUtils();
        Fracao fracao = new Fracao("2/5");

        // Operações de frações com inteiros.
        System.out.println(fracaoUtils.soma(fracao, 10));
        System.out.println(fracaoUtils.subtracao(fracao, 7));
        System.out.println(fracaoUtils.multiplicacao(fracao,10));
        System.out.println(fracaoUtils.divisao(fracao,2));

        // Operações de frações com frações
        Fracao fracao2 = new Fracao("3/5");
        System.out.println(fracaoUtils.soma(fracao, fracao2));
        System.out.println(fracaoUtils.subtracao(fracao, fracao2));
        System.out.println(fracaoUtils.multiplicacao(fracao,fracao2));
        System.out.println(fracaoUtils.divisao(fracao,fracao2));
    }

}
