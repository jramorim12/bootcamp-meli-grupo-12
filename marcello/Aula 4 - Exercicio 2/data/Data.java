package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

    private Date data;
    public GregorianCalendar gc;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Data(String data) throws ParseException {
        this.gc = new GregorianCalendar();
        this.gc.setTime(dateFormat.parse(data));
        this.data = dateFormat.parse(data);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return dateFormat.format(this.data);
    }
}
