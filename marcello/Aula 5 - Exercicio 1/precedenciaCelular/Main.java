package precedenciaCelular;

import precedenciaPessoa.Pessoa;
import precedenciaPessoa.SortUtil;

public class Main {

    public static void main(String[] args) {

        Pessoa marcello = new Pessoa("Marcello", "00000000001");
        Pessoa joao = new Pessoa("João", "00000000002");
        Pessoa rodrigo = new Pessoa("Rodrigo", "00000000003");
        Pessoa gabriel = new Pessoa("Gabriel", "00000000004");
        Pessoa nicolas = new Pessoa("Nicolas", "11100000001");

        Celular celular1 = new Celular("000000001", marcello);
        Celular celular2 = new Celular("000000002", joao);
        Celular celular3 = new Celular("100000002", rodrigo);
        Celular celular4 = new Celular("120000001", gabriel);
        Celular celular5 = new Celular("010000004", nicolas);

        Celular[] array = {celular4,celular2,celular3,celular1,celular5};

        SortUtil sortUtil = new SortUtil();

        sortUtil.sort(array);

        for(Celular celular : array) {
            System.out.println(celular);
        }

    }

}
