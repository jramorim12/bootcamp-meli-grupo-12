public class Celular implements Precedente<Celular>{
    private String Holder;
    private int Number;

    public Celular(int number, String holder) {
        Number = number;
        Holder = holder;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getHolder() {
        return Holder;
    }

    public void setHolder(String holder) {
        Holder = holder;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "Number=" + Number +
                ", Holder='" + Holder + '\'' +
                '}';
    }

    @Override
    public int precedeA(Celular celular) {
        if(celular.getNumber() > this.getNumber()){
            return 1;
        }else if(celular.getNumber() < this.getNumber()){
            return -1;
        }else{
            return 0;
        }
    }
}
