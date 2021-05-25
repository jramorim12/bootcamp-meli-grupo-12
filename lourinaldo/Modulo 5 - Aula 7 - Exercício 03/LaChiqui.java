import java.util.ArrayList;

public class LaChiqui {
    public static void main(String[] args) {

        PacoteFogosDeArtificio pacote1 = new PacoteFogosDeArtificio();
        PacoteFogosDeArtificio pacote2 = new PacoteFogosDeArtificio();

        FogoDeArtificio f1 = new FogoDeArtificio("Booooom 01");
        FogoDeArtificio f2 = new FogoDeArtificio("Booooom 02");
        FogoDeArtificio f3 = new FogoDeArtificio("Booooom 03");
        FogoDeArtificio f4 = new FogoDeArtificio("Booooom 04");
        FogoDeArtificio f5 = new FogoDeArtificio("Booooom 05");
        FogoDeArtificio f6 = new FogoDeArtificio("Booooom 06");

        pacote1.add(f1);
        pacote1.add(f2);
        pacote2.add(f3);
        pacote2.add(f4);

        ArrayList<FogosDeArtificioNode> list = new ArrayList<>();

        list.add(pacote1);
        list.add(pacote2);
        list.add(f5);
        list.add(f6);

        ArrayList<Convidado> convidados = new ArrayList<>();
        ConvidadoMeli convidadoMeli = new ConvidadoMeli("João");
        ConvidadoStandard convidadoStandard = new ConvidadoStandard("Maria");

        convidados.add(convidadoMeli);
        convidados.add(convidadoStandard);

        Evento evento = new Evento(convidados,list);

        evento.explodirFogos();
        evento.distribuirBolo();


    }
}
