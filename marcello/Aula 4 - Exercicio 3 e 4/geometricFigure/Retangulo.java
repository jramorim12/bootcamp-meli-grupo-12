package geometricFigure;

public class Retangulo extends GeometricFigure{

    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public Double calculaArea() {
        return (this.altura * this.largura);
    }

    @Override
    public String toString() {
        return "O retângulo informado tem as seguintes medidas: Largura: " + this.largura + " e Altura: " + this.altura;
    }
}
