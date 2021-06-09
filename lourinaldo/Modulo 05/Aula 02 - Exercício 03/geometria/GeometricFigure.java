package geometria;

public abstract class GeometricFigure {

    public abstract double area();

    @Override
    public String toString() {
        return "Área: "+area()+" m²" ;
    }
}
