package rpg;

import java.util.ArrayList;
import java.util.List;

public class ClasseUtils {

    public List<Classe> initClasses() {
        Classe guerreiro = new Classe("Guerreiro", "Tank");
        Classe mago = new Classe("Mago", "Support");
        Classe mercenario = new Classe("Mercenario", "DPS");
        Classe cavaleiro = new Classe("Cavaleiro", "DPS");
        Classe arqueiro = new Classe("Arqueiro", "All Around");

        List<Classe> classes = new ArrayList<>();
        classes.add(guerreiro);
        classes.add(mago);
        classes.add(mercenario);
        classes.add(cavaleiro);
        classes.add(arqueiro);

        return classes;
    }

}
