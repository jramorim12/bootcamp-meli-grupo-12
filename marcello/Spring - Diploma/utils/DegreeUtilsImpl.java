package br.com.marcello.DegreeProject.utils;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DegreeUtilsImpl implements DegreeUtils {

    @Override
    public Double getAverage(Map<String, Double> schoolReport) {

        Double total = 0.;
        Double totalSubjects = 0.;

        for(Map.Entry<String, Double> entry : schoolReport.entrySet()) {
            total += entry.getValue();
            totalSubjects += 1;
        }

        return (total / totalSubjects);

    }

    @Override
    public String getMessage(Double average) {
        if(average > 9)
            return "Congratulations, approved with merits";
        return "Student approved";
    }
}
