package controller;

import domain.Cliente;
import domain.Veiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

public class VeiculoController {
    public static Stack<String> logEmprestimos = new Stack<>();

    public void listarVeiculos(Veiculo[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null) {

                System.out.println(" Veiculo: " + (i + 1) + " --> " + veiculos[i].toString());
            }
        }
    }

    public void ordenarVeiculos(Veiculo[] veiculos) {
            Arrays.sort(veiculos);
    }
    public void listaVeiculosDisponiveis(Veiculo[] veiculos) {

        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].isAlugado() == false) {
                System.out.println(" Veiculo: " + (i + 1) + " --> " + veiculos[i].toString());
            }
        }
    }

    public void emprestarCarro(Queue<Cliente> filaDeEspera, Cliente[] clientes, Veiculo[] veiculos) {

        for (int i = 0; i < 7; i++) {
            if (filaDeEspera.peek().getNome().equals(clientes[i].getNome())) {
                for (int j = 0; j < 10; j++) {
                    if ((veiculos[j].getModelo().equals(clientes[i].getVeiculoDesejado())) && veiculos[j].isAlugado() == false) {
                        veiculos[j].setAlugado(true);
                        clientes[i].setVeiculoAlugado(veiculos[j].getModelo());
                        //EXEMPLO COM MANIPULAÇÃO DE DATAS - BÔNUS!!
                        //formatar a data como 12/04/2022 às 16:37:15
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss");
                        logEmprestimos.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " +
                                veiculos[j].getMarca() + ", " + veiculos[j].getModelo() + ", " + veiculos[j].getPlaca()
                                + ", foi EMPRESTADO para " + filaDeEspera.peek().getNome());

                    }
                }
                filaDeEspera.poll();
                break;
            }
        }
    }

    public void devolverCarro(Queue<Cliente> filaDeEspera, Cliente[] clientes, Veiculo[] veiculos) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Digite o nome do cliente");
        String nome = sc.next();

        for (int i = 0; i < 7; i++) {
            if (nome.equals(clientes[i].getNome())) {
                for (int j = 0; j < veiculos.length; j++) {
                    if ((clientes[i].getVeiculoAlugado().equals(veiculos[j].getModelo())) && (veiculos[j].isAlugado()) == true) {
                        veiculos[j].setAlugado(false);
                        //EXEMPLO COM MANIPULAÇÃO DE DATAS - BÔNUS!!
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss"); //formatar a data como 12/04/2022 às 16:37:15
                        logEmprestimos.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " +
                                veiculos[j].getMarca() + ", " + veiculos[j].getModelo() + ", " + veiculos[j].getPlaca()
                                + ", foi DEVOLVIDO por " + nome);
                    }
                }
                filaDeEspera.add(clientes[i]);
                break;
            }

        }
    }

    public void relatorioLocação() {
        logEmprestimos.forEach(System.out::println);
    }

    public void cadastra(Veiculo[] veiculos) {
        veiculos[0] = new Veiculo("Fiat", "TORO", "Preta", "AAA-1234",
                300, false);
        veiculos[1] = new Veiculo("Toyota", "HILUX", "Prata", "BBB-1234",
                500, false);
        veiculos[2] = new Veiculo("Hyunday", "HB20", "Branca", "CCC-1234",
                100, false);
        veiculos[3] = new Veiculo("Ford", "EcoSport", "Cinza", "DDD-1234",
                150, false);
        veiculos[4] = new Veiculo("VW", "FOX", "Branco", "EEE-1234",
                140, false);
        veiculos[5] = new Veiculo("Ford", "KA", "Preto", "FFF-1234",
                90, false);
        veiculos[6] = new Veiculo("GM", "Celta", "Verde", "GGG-1234",
                95, false);
        veiculos[7] = new Veiculo("GM", "Cruse", "Preto", "HHH-1234",
                255, false);
        veiculos[8] = new Veiculo("Fiat", "ARGO", "Preto", "III-1234",
                210, false);
        veiculos[9] = new Veiculo("Renault", "SANDERO", "Prata", "KKK-1234",
                220, false);
    }
}
