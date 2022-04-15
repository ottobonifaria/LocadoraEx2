package controller;

import domain.Cliente;
import domain.Relatorio;
import domain.Veiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VeiculoController {
    public static Stack<String> logEmprestimos = new Stack<>();

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static final Integer MAX_DE_VEICULOS = 10;
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    public int contaHistorico = 0;
    public int contaVeiculos = 0;

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

                System.out.println(" Veiculo: " + (i + 1) + " --> " + veiculos[i].toString());
            }
        }
    }

    public void ordenarVeiculos(Veiculo[] veiculos) {
        if (contaVeiculos < 10) {
            System.out.println("Complete o cadastro de veiculo para ordenar");
        } else {
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

    public void aluga(Cliente cliente, Veiculo veiculo, Relatorio[] relatorios) {
        cliente.setVeiculoAlugado(veiculo.getModelo());
        veiculo.setAlugado(true);
        cliente.setDataEmprestimo(formatterData.format(agora));
        cliente.setHoraEmprestimo(formatterHora.format(agora));

        relatorios[contaHistorico] = new Relatorio(cliente.getNome(), cliente.getVeiculoAlugado(),
                cliente.getDataEmprestimo(), cliente.getHoraEmprestimo(),
                cliente.getHoraEmprestimo(), cliente.getHoraDevolucao(), veiculo.getMarca(),
                veiculo.getModelo(), veiculo.getPlaca(), veiculo.isAlugado());
        contaHistorico++;
        System.out.println("Veiculo " + veiculo.getModelo() + " alugado com sucesso");
    }

    public void devolveVeiculo(Veiculo[] veiculos, Cliente[] clientes, Relatorio[] relatorios) {
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
                        relatorios[contaHistorico] = new Relatorio(clientes[i].getNome(), clientes[i].getVeiculoAlugado(),
                                clientes[i].getDataEmprestimo(), clientes[i].getHoraEmprestimo(),
                                clientes[i].getDataDevolucao(), clientes[i].getHoraDevolucao(), veiculos[j].getMarca(),
                                veiculos[j].getModelo(), veiculos[j].getPlaca(), veiculos[j].isAlugado());
                        contaHistorico++;
                        break;
                    }
                }
            }
        }
    }

    public void alugaOutroVeiculo(Cliente cliente, Veiculo[] veiculos, Relatorio[] relatorios) {
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

                    relatorios[contaHistorico] = new Relatorio(cliente.getNome(), cliente.getVeiculoAlugado(),
                            cliente.getDataEmprestimo(), cliente.getHoraEmprestimo(),
                            cliente.getHoraEmprestimo(), cliente.getHoraDevolucao(), veiculos[j].getMarca(),
                            veiculos[j].getModelo(), veiculos[j].getPlaca(), veiculos[j].isAlugado());
                    contaHistorico++;
                    break;
                } else {
                    System.out.println("Veiculo " + veiculos[j].getModelo() + " Não esta disponivel\n");
                }
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
                for (int j = 0; j < contaVeiculos -1; j++) {
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
        contaVeiculos = 10;
        veiculos[0] = new Veiculo("Fiat", "TORO", "Preta", "AAA-1234",
                200, false);
        veiculos[1] = new Veiculo("Toyota", "HILUX", "Prata", "BBB-1234",
                300, false);
        veiculos[2] = new Veiculo("Hyunday", "HB20", "Branca", "CCC-1234",
                100, false);
        veiculos[3] = new Veiculo("Ford", "EcoSport", "Cinza", "DDD-1234",
                150, false);
        veiculos[4] = new Veiculo("VW", "FOX", "Branco", "EEE-1234",
                250, false);
        veiculos[5] = new Veiculo("Ford", "KA", "Preto", "FFF-1234",
                250, false);
        veiculos[6] = new Veiculo("GM", "Celta", "Verde", "GGG-1234",
                250, false);
        veiculos[7] = new Veiculo("GM", "Cruse", "Preto", "HHH-1234",
                250, false);
        veiculos[8] = new Veiculo("Fiat", "ARGO", "Preto", "III-1234",
                250, false);
        veiculos[9] = new Veiculo("Renault", "SANDERO", "Prata", "KKK-1234",
                250, false);
    }
}
