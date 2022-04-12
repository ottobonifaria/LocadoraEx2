package controller;

import domain.Cliente;
import domain.Veiculo;

import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class ClienteController {

    public void cadastrarCliente(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                Scanner sc = new Scanner(System.in).useDelimiter("\n");
                System.out.println("====> Cadastrando Cliente <====");
                System.out.println("Digite o nome do cliente: ");
                String nome = sc.next();
                System.out.println("Digite o telefone: ");
                String telefone = sc.next();
                System.out.println("Digite o endereço: ");
                String endereço = sc.next();
                System.out.println("Digite o nome do veiculo desejado ");
                String veiculoDesejado = sc.next();
                clientes[i] = new Cliente(nome, telefone, endereço, veiculoDesejado,
                        null);
                return;
            }
        }
    }

    public void listarClientes(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println("\n========= Cliente Num. " + (i + 1) + " =========\n");
                System.out.println(clientes[i].toString());
            }
        }
    }

    public Optional<Cliente> consultaClientePeloNome(String nomeCliente, Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && nomeCliente.equals(clientes[i].getNome())) {
                return Optional.of(clientes[i]);
            }
        }
        return Optional.empty();
    }

    public void listaDeEspera(Queue<String> filaDeEspera){
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Digite o nome do cliente");
        String nomeCliente = sc.next();
        filaDeEspera.add(nomeCliente);
    }

}
