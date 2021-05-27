package br.com.marcello.DegreeProject.utils;

import java.util.Map;

public interface DegreeUtils {

    Double getAverage(Map<String, Double> schoolReport);

    String getMessage(Double average);

}
