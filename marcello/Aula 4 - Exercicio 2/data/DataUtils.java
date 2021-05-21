package data;

import java.util.Calendar;

public class DataUtils {

    public void insereDia(Data data, int quantidade) {
        data.gc.add(Calendar.DAY_OF_MONTH, quantidade);
        data.setData(data.gc.getTime());
        System.out.println("Data: " + data);
    }

    public void validaData(Data data) {
        if(data.dateFormat.toPattern().equalsIgnoreCase("dd/MM/yyyy")) {
            System.out.println("A data é valida!!");
            return;
        }

        System.out.println("A data é inválida!!");
    }


}
