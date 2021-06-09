package geometria;

import java.util.ArrayList;

public class GeometricFigureUtils {
    public static double areaMedia(ArrayList<GeometricFigure> arr){
        double aSum = 0;
        for(GeometricFigure gf: arr){
            aSum += gf.area();
        }

        return aSum/ arr.size();
    }
}
