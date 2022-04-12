import domain.Cliente;
import domain.Veiculo;

import java.util.LinkedList;
import java.util.Queue;

public class EsperaApp {

    public static void main(String[] args) {

        Veiculo veiculo = new Veiculo();

        Veiculo[] cadastroFrota = new Veiculo[5];
        cadastroFrota[0] = new Veiculo("Fiat", "Toro", "Preta", "AAA-1234",
                200, true);
        cadastroFrota[1] = new Veiculo("Toyota", "Hilux", "Prata", "BBB-1234",
                300, false);
        cadastroFrota[2] = new Veiculo("Hyunday", "hb20", "Branca", "CCC-1234",
                100, false);
        cadastroFrota[3] = new Veiculo("Ford", "EcoSport", "Cinza", "DDD-1234",
                150, false);
        cadastroFrota[4] = new Veiculo("VW", "Golf", "Preto", "EEE-1234",
                250, false);

        Cliente[] cadastroCliente = new Cliente[3];

        cadastroCliente[0] = new Cliente("João da Silva", "011-1234-5678",
                "Rua um, numero 123, Vila Mimosa- São Paulo",null,null);
        cadastroCliente[1] = new Cliente("Maria da Silva", "011-3333-5432",
                "Rua doi, numero 321, Vila Cesar - São Paulo",null,null);
        cadastroCliente[2] = new Cliente("Lucas Oliveira", "011-2222-4563",
                "Rua vinte , numero 333, Centro - São Paulo",null,null);

        Queue<Veiculo> frota = new LinkedList<Veiculo>();

        frota.add(cadastroFrota[0]);
        frota.add(cadastroFrota[1]);
        frota.add(cadastroFrota[2]);
        frota.add(cadastroFrota[3]);
        frota.add(cadastroFrota[4]);

        Queue<Cliente> cliente1 = new LinkedList<Cliente>();

        cliente1.add(cadastroCliente[0]);
        cliente1.add(cadastroCliente[1]);
        cliente1.add(cadastroCliente[2]);




        /* cadastroCliente[0].setVeiculoAlugado("AAA-1234");
        cadastroCliente[0].setDataEmprestimo(new Date());

        String ponta = String.valueOf(cliente1.peek());


        System.out.println(ponta);
        cliente1.remove();
        ponta = String.valueOf(cliente1.peek());
        System.out.println(ponta);
        cliente1.remove();
        ponta = String.valueOf(cliente1.peek());
        System.out.println(ponta);
        //System.out.println(frota);

         */
    }
}