package controller;

import domain.Cliente;
import domain.Relatorio;
import domain.Veiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VeiculoController {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static final Integer MAX_DE_VEICULOS = 10;
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    public int contaHistorico = 0;
    public int contaVeiculos =0;

    public void cadastraVeiculo(Veiculo[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] == null && veiculos.length <= MAX_DE_VEICULOS) {
                Scanner sc = new Scanner(System.in).useDelimiter("\n");
                System.out.println("====> Cadastrando Veiculo NUM : " + (i + 1) + " <====");
                System.out.println("Digite a marca do veiculo ");
                String marca = sc.next();
                System.out.println("Digite o modelo do veiculo");
                String modeloVeiculo = sc.next();
                System.out.println("Digite a cor do veiculo");
                String cor = sc.next();
                System.out.println("Digite a placa do veiculo");
                String placa = sc.next();
                System.out.println("Digite o valor da Diaria");
                int valorDaDiaria = sc.nextInt();
                boolean alugado = false;
                veiculos[i] = new Veiculo(marca, modeloVeiculo, cor, placa, valorDaDiaria, alugado);
                contaVeiculos++;
                return;
            }
        }
    }

    public void listarVeiculos(Veiculo[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null) {
                System.out.println("\n========= Veiculo Num. " + (i + 1) + " =========\n");
                System.out.println(veiculos[i].toString());
            }
        }
    }

    public void ordenarVeiculos(Veiculo[] veiculos) {
        if( contaVeiculos < 10) {
            System.out.println("Complete o cadastro de veiculo para ordenar");
        }else{
            Arrays.sort(veiculos);
        }
    }

    public void listaVeiculosDisponiveis(Veiculo[] veiculos) {

        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].isAlugado() == false) {
                System.out.println("\n========= Veiculo Nun. " + (i + 1) + " está disponivel =========\n");
                System.out.println(veiculos[i].toString());
            }
        }
    }

    public Optional<Veiculo> consultaVeiculo(String nomeVeiculo, Veiculo[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && nomeVeiculo.equalsIgnoreCase(veiculos[i].getModelo())) {
                return Optional.of(veiculos[i]);
            }
        }
        System.out.println("Veículo não encontrado");
        return Optional.empty();
    }

    public void aluga(Cliente cliente, Veiculo veiculo,Relatorio[] relatorios) {
        cliente.setVeiculoAlugado(veiculo.getModelo());
        veiculo.setAlugado(true);
        cliente.setDataEmprestimo(formatterData.format(agora));
        cliente.setHoraEmprestimo(formatterHora.format(agora));

        relatorios[contaHistorico] = new Relatorio(cliente.getNome(),cliente.getVeiculoAlugado(),
                cliente.getDataEmprestimo(),cliente.getHoraEmprestimo(),
                cliente.getHoraEmprestimo(),cliente.getHoraDevolucao(),veiculo.getMarca(),
                veiculo.getModelo(),veiculo.getPlaca(),veiculo.isAlugado());
        contaHistorico++;
        System.out.println("Veiculo " + veiculo.getModelo() + " alugado com sucesso");
    }

    public void devolveVeiculo(Veiculo[] veiculos, Cliente[] clientes,Relatorio[] relatorios) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Digite o nome do cliente");
        String nomeCliente = sc.next();
        for (int i = 0; i < clientes.length; i++) {
            if (nomeCliente.equals(clientes[i].getNome())) {
                String veiculoAlugado = clientes[i].getVeiculoAlugado();
                for (int j = 0; j < veiculos.length; j++) {
                    if (veiculoAlugado.equals(veiculos[j].getModelo())) {
                        veiculos[j].setAlugado(false);
                        clientes[i].setDataDevolucao(formatterData.format(agora));
                        clientes[i].setHoraDevolucao(formatterHora.format(agora));
                        relatorios[contaHistorico] = new Relatorio(clientes[i].getNome(),clientes[i].getVeiculoAlugado(),
                                clientes[i].getDataEmprestimo(),clientes[i].getHoraEmprestimo(),
                                clientes[i].getDataDevolucao(),clientes[i].getHoraDevolucao(),veiculos[j].getMarca(),
                                veiculos[j].getModelo(),veiculos[j].getPlaca(),veiculos[j].isAlugado());
                        contaHistorico++;
                        break;
                    }
                }
            }
        }
    }

    public void alugaOutroVeiculo(Cliente cliente, Veiculo[] veiculos,Relatorio[] relatorios) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Escolha outro veiculo disponivel a ser alugado");
        listaVeiculosDisponiveis(veiculos);
        System.out.println("Digite o modelo de Veiculo a ser alugado");
        String modelo = sc.next().toUpperCase();
        for (int j = 0; j < veiculos.length; j++) {
            if (modelo.equalsIgnoreCase(veiculos[j].getModelo())) {
                if (veiculos[j].isAlugado() == false) {
                    cliente.setVeiculoAlugado(veiculos[j].getModelo());
                    veiculos[j].setAlugado(true);
                    cliente.setDataEmprestimo(formatterData.format(agora));
                    cliente.setHoraEmprestimo(formatterHora.format(agora));
                    System.out.println("Veiculo " + veiculos[j].getModelo() + " alugado com sucesso");

                    relatorios[contaHistorico] = new Relatorio(cliente.getNome(),cliente.getVeiculoAlugado(),
                            cliente.getDataEmprestimo(),cliente.getHoraEmprestimo(),
                            cliente.getHoraEmprestimo(),cliente.getHoraDevolucao(),veiculos[j].getMarca(),
                            veiculos[j].getModelo(),veiculos[j].getPlaca(),veiculos[j].isAlugado());
                    contaHistorico++;
                    break;
                } else {
                    System.out.println("Veiculo " + veiculos[j].getModelo() + " Não esta disponivel\n");
                }
            }
        }

    }



}
