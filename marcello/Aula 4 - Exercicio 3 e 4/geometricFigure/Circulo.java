package geometricFigure;

public class Circulo extends GeometricFigure {

    private Double raio;

    public Circulo(Double raio) {
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public Double calculaArea() {
        return (Math.PI * Math.pow(this.raio,2));
    }

    @Override
    public String toString() {
        return "O raio da circuferência informado é: " + this.raio;
    }
}
