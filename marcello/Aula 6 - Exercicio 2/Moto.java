package dakar;

public class Moto extends Veiculo {

    static Double pesoMoto = 300.;
    static Integer qtdeRodas = 2;

    public Moto(Double velocidade, Double aceleracao, Double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, pesoMoto, qtdeRodas);
    }
}
