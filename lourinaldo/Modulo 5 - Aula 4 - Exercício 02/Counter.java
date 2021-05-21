public class Counter {
    private int valor;

    public Counter(int valor) {
        this.valor = valor;
    }

    public Counter() {
    }

    public Counter(Counter counter){
        this.valor = counter.getValor();
    }

    public int getValor() {
        return valor;
    }

    public void aumentarValor(int n){
        this.setValor(this.valor + n);
    }

    public void diminuirValor(int n){
        this.setValor(this.valor - n);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
