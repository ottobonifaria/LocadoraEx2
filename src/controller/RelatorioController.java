package controller;

import domain.Cliente;
import java.util.Queue;

public class RelatorioController {
    public void imprimeFilaDeEspera(Queue<Cliente> filaDeEspera){
        for(Cliente cliente: filaDeEspera){
            System.out.println("Nome: " + cliente.getNome() + " Modelo: " + cliente.getVeiculoDesejado());
        }
    }
}
