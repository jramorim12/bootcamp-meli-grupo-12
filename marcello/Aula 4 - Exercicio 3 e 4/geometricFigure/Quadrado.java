package geometricFigure;

public class Quadrado extends GeometricFigure{

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public Double calculaArea() {
        return Math.pow(this.lado, 2);
    }

    @Override
    public String toString() {
        return "O lado do quadrado informado é: " + this.lado;
    }
}
