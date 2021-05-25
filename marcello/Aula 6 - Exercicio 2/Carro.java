package dakar;

public class Carro extends Veiculo {

    static Double pesoCarro = 1000.;
    static Integer qtdeRodas = 4;

    public Carro(Double velocidade, Double aceleracao, Double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, pesoCarro, qtdeRodas);
    }

}
