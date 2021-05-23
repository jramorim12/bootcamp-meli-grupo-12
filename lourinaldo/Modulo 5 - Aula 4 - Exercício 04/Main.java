public class Main {
    public static void main(String[] args) {

        FuncionarioPJ fPJ = new FuncionarioPJ("Nome PJ", 32133132, 30, 100);
        Tecnico fT = new Tecnico("Nome Técnico", 32131123, 5);
        Analista fA = new Analista("Nome analista", 3123131, 4);
        Gerente fG = new Gerente("Nome Gerente", 3989093, 4);
        Diretor fD = new Diretor("Nome Diretor", 3273612, 100000);


        System.out.println(fPJ.pagarSalario());
        System.out.println(fT.pagarSalario());
        System.out.println(fA.pagarSalario());
        System.out.println(fG.pagarSalario());
        System.out.println(fD.pagarSalario());

    }
}
