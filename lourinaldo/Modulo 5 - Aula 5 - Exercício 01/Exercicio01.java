public class Exercicio01 {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Pessoa 01", 12345678910L);
        Pessoa p2 = new Pessoa("Pessoa 02", 32345678910L);
        Pessoa p3 = new Pessoa("Pessoa 03", 42345678910L);
        Pessoa p4 = new Pessoa("Pessoa 04", 52345678910L);
        Pessoa p5 = new Pessoa("Pessoa 05", 62345678910L);

        Precedente<Pessoa>[] arrPessoas = new Precedente[5];
        arrPessoas[0] = p4;
        arrPessoas[1] = p2;
        arrPessoas[2] = p3;
        arrPessoas[3] = p5;
        arrPessoas[4] = p1;

       SortUtil.sort(arrPessoas);

//     Exibindo pessoas de forma ordenada através do CPF
        System.out.println("Pessoas de forma ordenada: ");
       for(Precedente<Pessoa> p: arrPessoas){
           System.out.println(p);
       }


        Celular c1 = new Celular(1234567,"Pessoa 01");
        Celular c2 = new Celular(2345678,"Pessoa 02");
        Celular c3 = new Celular(3456789,"Pessoa 03");
        Celular c4 = new Celular(5678901,"Pessoa 04");
        Celular c5 = new Celular(6678901,"Pessoa 05" );
        Precedente<Celular>[] arrCelulares = new Precedente[5];
        arrCelulares[0] = c4;
        arrCelulares[1] = c2;
        arrCelulares[2] = c3;
        arrCelulares[3] = c5;
        arrCelulares[4] = c1;

        SortUtil.sort(arrCelulares);
        System.out.println("Celulares de forma ordenada: ");

//     Exibindo Celulares de forma ordenada através do Número

        for(Precedente<Celular> c: arrCelulares){
            System.out.println(c);
        }


    }
}
