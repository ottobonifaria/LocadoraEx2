package controller;

import domain.Cliente;
import domain.Relatorio;
import domain.Veiculo;

import java.util.Queue;
import java.util.Stack;

public class RelatorioController {
    public static Stack<String> logEmprestimos = new Stack<>();

    public void imprimeHistorico(Veiculo[] veiculo, Cliente[] clientes, Relatorio[] relatorios, int contaHistorico) {
        for (int i = 0; i < contaHistorico; i++) {
            if (relatorios[i].isAlugado()== true) {
                System.out.println(relatorios[i].getDataEmprestimo() + " às " + relatorios[i].getHoraEmprestimo() +
                        " Carro: " + relatorios[i].getModelo() + " Marca: " + relatorios[i].getMarca() +
                        " Placa : " + relatorios[i].getPlaca() + " foi EMPRESTADO por " + relatorios[i].getNome() + " .\n");
            }
            if(relatorios[i].isAlugado() == false){
                System.out.println(relatorios[i].getDataDevolucao() + " às " + relatorios[i].getHoraDevolucao() +
                        " Carro: " + relatorios[i].getModelo() + " Marca: " + relatorios[i].getMarca() +
                        " Placa : " + relatorios[i].getPlaca() + " foi DEVOLVIDO por " + relatorios[i].getNome() + " .\n");
            }
        }
    }

    public void imprimeFilaDeEspera(Queue<Cliente> filaDeEspera){

        for(Cliente cliente: filaDeEspera){

            System.out.println("Nome: " + cliente.getNome() + " Modelo: " + cliente.getVeiculoDesejado());

        }
    }



}
