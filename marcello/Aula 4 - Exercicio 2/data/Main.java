package data;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        DataUtils dataUtils = new DataUtils();
        Data data;
        try{
            data = new Data("27/01/1998");
        } catch (Exception e) {
            throw new RuntimeException("Problemas ao converter a data inserida para o formato dd/MM/yyyy");
        }

        dataUtils.insereDia(data, 1000);
        dataUtils.validaData(data);

    }

}
