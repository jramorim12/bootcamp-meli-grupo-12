package geometria;

public class Circulo extends  GeometricFigure{
    private double radius;

    public Circulo(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2*Math.PI*Math.pow(this.radius, 2);
    }
}
