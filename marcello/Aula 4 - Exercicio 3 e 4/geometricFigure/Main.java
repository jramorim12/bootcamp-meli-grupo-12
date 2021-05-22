package geometricFigure;

public class Main {

    public static void main(String[] args) {
        AreaUtils areaUtils = new AreaUtils();
        GeometricFigure[] figuresArray = {new Quadrado(3.), new Retangulo(5., 4.), new Circulo(2.)};
        Double areaMedia = areaUtils.calculaAreaMedia(figuresArray);
        System.out.println("A área média das figuras informadas é: " + areaMedia);
    }

}
