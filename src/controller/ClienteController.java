package controller;

import domain.Cliente;
import java.util.Queue;
import java.util.Scanner;

public class ClienteController {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void listarClientes(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println(" Cliente: "+ (i+1) + " --> " + clientes[i].toString());
            }
        }
    }

    public void addListaDeEspera(Queue<Cliente> filaDeEspera,Cliente[] clientes){

        for(int i = 0; i < clientes.length; i++){
                filaDeEspera.add(clientes[i]);
        }
    }

    public void cadastraCliente(Cliente[] clientes) {

        clientes[0] = (new Cliente("João", "011-1234-5678",
                "Rua um, numero 123, Vila Mimosa- São Paulo", "TORO", null));
        clientes[1] = (new Cliente("Maria", "011-3333-5432",
                "Rua dois, numero 321, Vila Cesar - São Paulo", "HB20", null));
        clientes[2] = (new Cliente("Beto", "011-2222-4563",
                "Rua vinte , numero 333, Centro - São Paulo", "GOLF", null));
        clientes[3] = (new Cliente("Jorge", "011-2212-4563",
                "Rua do cafe , numero 100, Centro - São Paulo", "SANDERO", null));
        clientes[4] = (new Cliente("Joaquim", "011-2222-4563",
                "Rua do Açucar , numero 2, Centro - São Paulo", "HILUX", null));
        clientes[5] = (new Cliente("Marcio", "011-2222-4563",
                "Rua do Açucar , numero 2, Centro - São Paulo", "EcoSport", null));
        clientes[6] = (new Cliente("Mario", "011-2222-4563",
                "Rua do Verde , numero 12, Centro - São Paulo", "FOX", null));
    }
}
