package saveTheRopa;

import sorter.Sorter;

import java.util.HashMap;
import java.util.*;

public class GuardaRoupa {

    private Scanner sc = new Scanner(System.in);
    private Counter counter = new Counter();
    private Map<Integer, List<Vestuario>> deposito = new HashMap<>();

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Map<Integer, List<Vestuario>> getDeposito() {
        return deposito;
    }

    public void setDeposito(Map<Integer, List<Vestuario>> deposito) {
        this.deposito = deposito;
    }

    public void getRoupasParaGuardar() {
        sc.nextLine();
        String continuar = "";
        List<Vestuario> listaRoupas = new ArrayList<>();
        do {
            System.out.print("Informe a marca da roupa que vai guardar: ");
            String marca = sc.nextLine();
            System.out.print("Informe o modelo da roupa que você vai guardar: ");
            String modelo = sc.nextLine();
            Vestuario roupa = new Vestuario(marca, modelo);
            listaRoupas.add(roupa);
            System.out.println("================================");
            System.out.print("Deseja guardar mais roupas? (S/N): ");
            continuar = sc.nextLine();
        } while(continuar.equalsIgnoreCase("S"));
        this.guardarVestuario(listaRoupas);
    }

    public Integer guardarVestuario(List<Vestuario> listaDeVestuario) {
        this.deposito.put(this.counter.getCount(), listaDeVestuario);
        System.out.println("O vestuário foi armanezado no volume: " + this.counter.getCount());
        this.counter.increment();
        return this.counter.getCount();
    }

    public void mostrarVestuario() {
        System.out.println("================================");
        for(Map.Entry<Integer, List<Vestuario>> entry : this.deposito.entrySet()) {
            System.out.println("O vestuário está armazenado no volume: " + entry.getKey());
            System.out.println("E contem as seguintes roupas: " + "\n");
            entry.getValue().forEach(System.out::println);
        }
    }

    public List<Vestuario> devolverVestuario(Integer id) {
        System.out.println("================================");
        System.out.println("Você retirou o seguinte vestuário: ");
        this.deposito.get(id).forEach(System.out::println);
        this.counter.decrement();
        return this.deposito.remove(id);
    }

    public void initSaveTheRopa(){
        System.out.println("Bem vindo à SaveTheRopa S.A");
        System.out.println("Aqui é o lugar perfeito para você guardar suas roupas!!");
        this.initMenu();
    }

    public void initMenu() {
        int opcao;
        do {
            System.out.println("================================");
            System.out.println("Por favor, informe a opcão que você deseja realizar: ");
            System.out.println("1. Guardar roupas: ");
            System.out.println("2. Ver quais roupas estão guardadas");
            System.out.println("3. Pegar uma roupa armazenada de volta.");
            System.out.println("4. Sair.");
            System.out.print("Digite aqui sua opção (1 a 4): ");
            opcao = sc.nextInt();
            if (opcao < 1 || opcao > 4) {
                System.out.print("Opção informada inválida, por favor digite novamente: ");
                opcao = sc.nextInt();
                this.getOpcao(opcao);
            }
            this.getOpcao(opcao);
        } while (opcao != 4);
    }

    public Boolean guardaRoupaIsEmpty() {
        if(this.deposito.isEmpty()){
            System.out.println("================================");
            System.out.println("Não temos nada armazenado!!");
            return true;
        }
        return false;
    }

    public void getOpcao(int opcao) {
        switch (opcao) {
            case 1:
                this.getRoupasParaGuardar();
                break;
            case 2:
                if(this.guardaRoupaIsEmpty())
                    this.initMenu();
                this.mostrarVestuario();
                break;
            case 3:
                if(this.guardaRoupaIsEmpty())
                    this.initMenu();
                System.out.println("Informe o ID do volume que a roupa que você deseja retirar está armazenada: ");
                Integer id = sc.nextInt();
                this.devolverVestuario(id);
                break;
            case 4:
                System.out.println("Agradecemos por usar SaveTheRopa");
                System.out.println("Até breve!");
                System.exit(0);
                break;
        }
    }

}
