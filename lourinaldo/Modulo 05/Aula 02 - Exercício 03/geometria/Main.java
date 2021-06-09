package geometria;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(4,3);
        Circulo circulo = new Circulo(3);
        Retangulo retangulo = new Retangulo(5,5);

        ArrayList<GeometricFigure> arr = new ArrayList<>();
        arr.add(triangulo);
        arr.add(circulo);
        arr.add(retangulo);

        System.out.println("Área média: "+ GeometricFigureUtils.areaMedia(arr)+"m²");
    }
}
