package geometria;

public class Triangulo extends GeometricFigure{

    private double base;
    private double height;

    public Triangulo(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return this.getBase()*this.getHeight()/2;
    }
}
