import java.util.ArrayList;

public class Evento {

    private ArrayList<Convidado> listaConvidados;
    private ArrayList<FogosDeArtificioNode> listaDeFogos;

    public Evento(ArrayList<Convidado> listaConvidados, ArrayList<FogosDeArtificioNode> listaDeFogos) {
        this.listaConvidados = listaConvidados;
        this.listaDeFogos = listaDeFogos;
    }

    public ArrayList<Convidado> getListaConvidados() {
        return listaConvidados;
    }

    public void setListaConvidados(ArrayList<Convidado> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public ArrayList<FogosDeArtificioNode> getListaDeFogos() {
        return listaDeFogos;
    }

    public void setListaDeFogos(ArrayList<FogosDeArtificioNode> listaDeFogos) {
        this.listaDeFogos = listaDeFogos;
    }

    public void addFogos(FogosDeArtificioNode fa){
        listaDeFogos.add(fa);
    }

    public void distribuirBolo(){
        for(Convidado v : this.listaConvidados){
            v.comerBolo();
        }
    }

    public void explodirFogos(){
        for(FogosDeArtificioNode f : this.listaDeFogos){
            if(f instanceof PacoteFogosDeArtificio){
                for(FogosDeArtificioNode i : (ArrayList<FogosDeArtificioNode>) f){
                    ((FogoDeArtificio) i).explodir();
                }
            }else{
                ((FogoDeArtificio) f).explodir();
            }
        }
    }

}


