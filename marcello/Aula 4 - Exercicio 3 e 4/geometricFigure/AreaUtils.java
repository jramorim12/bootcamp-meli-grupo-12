package geometricFigure;

public class AreaUtils {

    public Double calculaAreaMedia(GeometricFigure[] array) {
        Double soma = 0.;
        for(GeometricFigure figure : array) {
            soma += figure.calculaArea();
        }
        return (soma / array.length + 1);
    }

}
