import java.util.ArrayList;

public class SaveTheRopa {
    public static void main(String[] args) {
        ArrayList<Vestuario> lista1 = new ArrayList<>();
        ArrayList<Vestuario> lista2 = new ArrayList<>();
        ArrayList<Vestuario> lista3 = new ArrayList<>();

        Vestuario v1 = new Vestuario("Marca 01", "Modelo 01");
        Vestuario v2 = new Vestuario("Marca 02", "Modelo 02");
        Vestuario v3 = new Vestuario("Marca 03", "Modelo 03");
        Vestuario v4 = new Vestuario("Marca 04", "Modelo 04");
        Vestuario v5 = new Vestuario("Marca 05", "Modelo 05");
        Vestuario v6 = new Vestuario("Marca 06", "Modelo 06");

        lista1.add(v1);
        lista1.add(v2);
        lista2.add(v3);
        lista2.add(v4);
        lista3.add(v5);
        lista3.add(v6);

        GuardaRoupa guardaRoupa = new GuardaRoupa();
        System.out.println("Ids dos itens adicionados: ");
        System.out.println(guardaRoupa.guardarVestuario(lista1));
        System.out.println(guardaRoupa.guardarVestuario(lista2));
        System.out.println(guardaRoupa.guardarVestuario(lista3));
        System.out.println("\n" + "Todos os vestuários");
        guardaRoupa.mostrarVestuario();

        System.out.println("\n" + "Lista coletada através do ID devolvido");
        for(Vestuario v: guardaRoupa.devolverVestuario(3)){
            System.out.println(v);
        }




    }
}
