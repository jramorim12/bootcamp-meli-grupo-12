package rpg;

import java.util.ArrayList;
import java.util.List;

public class ArmaUtils {

    public List<Arma> initArmas() {

        Arma cajado = new Arma("Cajado", 50, 99);
        Arma lanca = new Arma("Lança", 75, 99);
        Arma claymore = new Arma("Claymore", 200, 99);
        Arma adagas = new Arma("Adagas", 25, 99);
        Arma arco = new Arma("Arco e Flecha", 60, 99);
        List<Arma> armas = new ArrayList<>();

        armas.add(cajado);
        armas.add(lanca);
        armas.add(claymore);
        armas.add(adagas);
        armas.add(arco);

        return armas;

    }
}
