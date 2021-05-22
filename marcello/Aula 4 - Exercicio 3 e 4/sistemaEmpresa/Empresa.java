package sistemaEmpresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {


    public static void main(String[] args) {

        Tecnico tecnico = new Tecnico("João", "000001",true);
        Analista analista = new Analista("Marcos","000002", false);
        Gerente gerente = new Gerente("Lucas", "000003", true);
        Diretor diretor = new Diretor("Matheus", "000004");
        FuncionarioPJ pj = new FuncionarioPJ("Rodrigo", "000005",80., 70.);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(tecnico);
        funcionarios.add(analista);
        funcionarios.add(gerente);
        funcionarios.add(diretor);
        funcionarios.add(pj);

        for(Funcionario func : funcionarios) {
            System.out.println(func);
            System.out.println("\n");
        }

    }

}
