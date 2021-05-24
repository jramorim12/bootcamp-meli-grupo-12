package precedenciaCelular;

import precedenciaPessoa.Pessoa;
import precedenciaPessoa.Precedente;

public class Celular implements Precedente<Celular> {

    @Override
    public int precede(Celular celular) {
        for(int i=0; i < celular.getNumber().length(); i++) {
            if(this.number.charAt(i) != celular.getNumber().charAt(i)) {
                return Character.compare(this.number.charAt(i), celular.getNumber().charAt(i));
            }
        }
        return 0;
    }

    private String number;
    private Pessoa holder;

    public Celular(String number, Pessoa holder) {
        this.number = number;
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Pessoa getHolder() {
        return holder;
    }

    public void setHolder(Pessoa holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "Número: " + this.number + "\n"
                + "Dono: " + this.holder.getNome() + "\n";
    }
}
