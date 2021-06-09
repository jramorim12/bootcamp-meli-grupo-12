public class Fracao {

    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fracao adicionar(Fracao fracao){
        Fracao resultado = new Fracao(this.numerador*fracao.getDenominador() + this.denominador*fracao.getNumerador(), this.denominador* fracao.getDenominador());
        return resultado;
    }

    public Fracao subtrair(Fracao fracao){

        Fracao resultado = new Fracao(this.numerador*fracao.getDenominador() - this.denominador*fracao.getNumerador(), this.denominador* fracao.getDenominador());
        return resultado;
    }

    public Fracao multiplicar(Fracao fracao){
        Fracao resultado = new Fracao(this.numerador*fracao.getNumerador(), this.denominador * fracao.getDenominador());
        return resultado;
    }

    public Fracao dividir(Fracao fracao){
        Fracao resultado = new Fracao(this.numerador*fracao.getDenominador(), this.denominador * fracao.getNumerador());
        return resultado;
    }

    public Fracao adicionar(int n){
        Fracao resultado = new Fracao(this.numerador + this.denominador*n, this.denominador);
        return resultado;
    }

    public Fracao subtrair(int n){

        Fracao resultado = new Fracao(this.numerador - this.denominador*n, this.denominador);
        return resultado;
    }

    public Fracao multiplicar(int n){
        Fracao resultado = new Fracao(this.numerador*n, this.denominador);
        return resultado;
    }

    public Fracao dividir(int n){
        Fracao resultado = new Fracao(this.numerador, this.denominador * n);
        return resultado;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString(){
        return this.getNumerador()+"/"+ this.getDenominador();
    }
}
