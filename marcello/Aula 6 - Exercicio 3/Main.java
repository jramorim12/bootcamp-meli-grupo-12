package laChiqui;

public class Main {

    public static void main(String[] args) {

        FogosDeArtificio[] array1 = {new FogosDeArtificio("BOOM")};
        FogosDeArtificio[] array2 = {new FogosDeArtificio("KABOOOOOM"), new FogosDeArtificio("BOOOOOM"), new FogosDeArtificio("KABUM")};
        FogosDeArtificio[] array3 = {new FogosDeArtificio("KABUM")};

        LaChiqui laChiqui = new LaChiqui();
        laChiqui.criaConvidado();
        laChiqui.adicionaFogos(array1);
        laChiqui.adicionaFogos(array2);
        laChiqui.adicionaFogos(array3);
        laChiqui.apagaVela();
    }

}
