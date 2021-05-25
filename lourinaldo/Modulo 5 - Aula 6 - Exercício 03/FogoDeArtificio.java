public class FogoDeArtificio implements FogosDeArtificioNode {
    private String somExplosao;

    public FogoDeArtificio(String somExplosao) {
        this.somExplosao = somExplosao;
    }

    public String getSomExplosao() {
        return somExplosao;
    }

    public void setSomExplosao(String somExplosao) {
        this.somExplosao = somExplosao;
    }

    public void explodir(){
        System.out.println(somExplosao);
    }
}
