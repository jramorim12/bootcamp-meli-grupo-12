package fracao;

public class FracaoUtils {

    public double converteFracao(Fracao fracao){
        String[] array = fracao.getFracao().split("/");
        double numerador = Double.parseDouble(array[0]);
        double denominador = Double.parseDouble(array[array.length - 1]);
        return numerador / denominador;
    };

    public String soma(Fracao fracao, Integer valor) {
        Double fracaoConvertida = this.converteFracao(fracao);
        return "O valor da soma entre " + fracao + " e " + valor + " é: " + (fracaoConvertida + valor.doubleValue());
    }

    public String subtracao(Fracao fracao, Integer valor) {
        Double fracaoConvertida = this.converteFracao(fracao);
        return "O valor da subtração entre " + fracao + " e " + valor + " é: " + (fracaoConvertida - valor.doubleValue());

    }

    public String multiplicacao(Fracao fracao, Integer valor) {
        Double fracaoConvertida = this.converteFracao(fracao);
        return "O valor da multiplicação entre " + fracao + " e " + valor + " é: " + (fracaoConvertida * valor.doubleValue());
    }

    public String divisao(Fracao fracao, Integer valor) {
        Double fracaoConvertida = this.converteFracao(fracao);
        return "O valor da divisão entre " + fracao + " e " + valor + " é: " + (fracaoConvertida / valor.doubleValue());
    }

    public String soma(Fracao fracao, Fracao fracao2) {
        Double fracaoConvertida1 = this.converteFracao(fracao);
        Double fracaoConvertida2 = this.converteFracao(fracao2);
        return "O valor da soma entre " + fracaoConvertida1 + " e " + fracaoConvertida2 + " é: " + (fracaoConvertida1 + fracaoConvertida2);
    }

    public String subtracao(Fracao fracao, Fracao fracao2) {
        Double fracaoConvertida1 = this.converteFracao(fracao);
        Double fracaoConvertida2 = this.converteFracao(fracao2);
        return "O valor da subtração entre " + fracaoConvertida1 + " e " + fracaoConvertida2 + " é: " + (fracaoConvertida1 - fracaoConvertida2);

    }

    public String multiplicacao(Fracao fracao, Fracao fracao2) {
        Double fracaoConvertida1 = this.converteFracao(fracao);
        Double fracaoConvertida2 = this.converteFracao(fracao2);
        return "O valor da multiplicação entre " + fracaoConvertida1 + " e " + fracaoConvertida2 + " é: " + (fracaoConvertida1 * fracaoConvertida2);
    }

    public String divisao(Fracao fracao, Fracao fracao2) {
        Double fracaoConvertida1 = this.converteFracao(fracao);
        Double fracaoConvertida2 = this.converteFracao(fracao2);
        return "O valor da divisão entre " + fracaoConvertida1 + " e " + fracaoConvertida2 + " é: " + (fracaoConvertida1 / fracaoConvertida2);
    }

}
