package geometria;

public class Retangulo extends GeometricFigure{

    private double base;
    private double height;

    public Retangulo(double base, double height) {
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
        return this.getBase()*this.getHeight();
    }
}
