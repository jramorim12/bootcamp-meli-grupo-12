import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

    public GregorianCalendar gc = new GregorianCalendar();
    public SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date data;

    public Data(String data){
        try{
            this.gc.setTime(dtFormat.parse(data));
            this.data = dtFormat.parse(data);
        }catch (ParseException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public Data(Date data){
        this.gc.setTime(data);
        this.data = data;
    }

    public void addDias(int n){
        this.gc.add(Calendar.DAY_OF_MONTH, n);
        this.data = gc.getTime();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.dtFormat.format(this.data);
    }
}