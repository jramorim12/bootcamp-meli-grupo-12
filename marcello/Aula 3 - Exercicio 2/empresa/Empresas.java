package empresa;

public class Empresas {
    
    private static double valorEmpresaX = 1.13;
    private static double valorEmpresaY = 18.4;
    private static double crescimentoAnualEmpresaX = 2.48;
    private static double crescimentoAnualEmpresaY = 1.32;
    private static int ano = 2021;

    public static void main(String[] args) {
        Empresas.imprimeValores();
    }

    private static double calculaCrescimentoAnualEmpresaX() {
        Empresas.valorEmpresaX = Empresas.valorEmpresaX * Empresas.crescimentoAnualEmpresaX;
        return Empresas.valorEmpresaX;
    }

    private static double calculaCrescimentoAnualEmpresaY(){
        Empresas.valorEmpresaY = Empresas.valorEmpresaY * Empresas.crescimentoAnualEmpresaY;
        return Empresas.valorEmpresaY;
    }

    private static int incrementaAno(){
        Empresas.ano++;
        return Empresas.ano;
    }

    private static void imprimeValores() {
        do {
            Empresas.incrementaAno();
            System.out.println("Empresa X - 01/01/" + Empresas.ano + " - Valor da Empresa X: " + Empresas.calculaCrescimentoAnualEmpresaX() + "m");
            System.out.println("Empresa X - 01/01/" + Empresas.ano + " - Valor da Empresa Y: " + Empresas.calculaCrescimentoAnualEmpresaY() + "m");
        } while(!Empresas.empresaXSuperouEmpresaY());
        System.out.println("O ano que a empresa X supera a Empresa Y é: " + Empresas.ano);
    }

    private static Boolean empresaXSuperouEmpresaY() {
        return Empresas.valorEmpresaX > Empresas.valorEmpresaY;
    }

}
