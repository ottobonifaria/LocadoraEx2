import controller.ClienteController;
import controller.RelatorioController;
import controller.VeiculoController;
import domain.Cliente;
import domain.Relatorio;
import domain.Veiculo;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String menu;
        Cliente[] clientes = new Cliente[100];
        ClienteController clienteController = new ClienteController();

        Veiculo[] veiculos = new Veiculo[10];
        VeiculoController veiculoController = new VeiculoController();

        Relatorio[] relatorios = new Relatorio[100];
        RelatorioController relatorioController = new RelatorioController();

        cadastra(veiculos); //cadastra 5 veiculos para ter um inicio
        cadastraCliente(clientes); //Cadstra 3 Clientes para ter um inicio
        Queue<String> filaEspera = new ArrayBlockingQueue<>(10);

        do {
            exibirMenu();
            menu = sc.next();
            switch (menu) {
                case "1":
                    System.out.println("====== Cadastrando Veiculo");
                    veiculoController.cadastraVeiculo(veiculos);
                    break;
                case "2":
                    System.out.println("\n===== FIFTCARS ===== \n Confira nossos modelos\n");
                    System.out.println("=====> LISTA DE VEICULOS CADASTRADO <=====");
                    veiculoController.listarVeiculos(veiculos);
                    break;
                case "3":
                    System.out.println("CADASTRANDO CLIENTE");
                    clienteController.cadastrarCliente(clientes);
                    break;
                case "4":
                    System.out.println("LISTA DE CLIENTES CADASTRADOS");
                    clienteController.listarClientes(clientes);
                    break;
                case "5":
                    System.out.println("LISTA DE VEICULOS ORDENADOS POR MENOR VALOR");
                    veiculoController.ordenarVeiculos(veiculos);
                    break;
                case "6":
                    System.out.println("lISTA DE VEICULOS DISPONIVEIS PARA ALUGAR");
                    veiculoController.listaVeiculosDisponiveis(veiculos);
                    break;
                case "7":
                    System.out.println("Digite o nome do cliente");
                    String nomeCliente = sc.next();

                    Cliente cliente = clienteController.consultaClientePeloNome(nomeCliente, clientes).get();
                    Optional<Veiculo> veiculo = veiculoController.consultaVeiculo(cliente.getVeiculoDesejado(), veiculos);

                    if (veiculo.isPresent() && veiculo.get().isAlugado() == false) {
                        System.out.println("Veiculo desejado " + veiculo.get().getModelo() + " está disponível, deseja alugar este veiculo? - S- sim N-não");
                        String input = sc.next();
                        if (input.equalsIgnoreCase("S")) {
                            veiculoController.aluga(cliente, veiculo.get(),relatorios);
                        } else {
                            veiculoController.alugaOutroVeiculo(cliente, veiculos,relatorios);
                        }
                    }
                    break;
                case "8":
                    System.out.println("DEVOLUÇÃO");
                    veiculoController.devolveVeiculo(veiculos,clientes,relatorios);

                    break;
                case "9":
                    System.out.println("LISTA DE ESPERA");
                    clienteController.listaDeEspera(filaEspera);
                    relatorioController.imprimeFilaDeEspera(filaEspera,clientes);
                    break;
                case "10":
                    System.out.println("RELATÓRIO DE LOCAÇÃO");
                    relatorioController.imprimeHistorico(veiculos,clientes,relatorios, veiculoController.contaHistorico);
                    break;
                case "11":
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while(menu !="10");
    }
    static public void exibirMenu() {
        System.out.println("===================== LOCADORA ============================");
        System.out.println(" 1 - CADASTRAR VEICULOS  |  2 - LISTAR VEICULOS CADASTRADOS");
        System.out.println(" 3 - CADASTRAR CLIENTES  |  4 - LISTAR CLIENTES CADASTRADOS");
        System.out.println(" 5 - ORDENAR MENOR VALOR |  6 - CONSULTA VEICULO DISPONIVEL PARA ALUGAR");
        System.out.println(" 7 - ALUGA VEICULO       |  8 - DEVOLUÇÃO DE VEICULO");
        System.out.println(" 9 - LISTA DE ESPERA     |  10 - RELATORIO DE LOCAÇÃO");
        System.out.println("                     11 - SAIR");


    }
    static public void cadastra(Veiculo[] veiculos) {
        veiculos[0] = new Veiculo("Fiat", "Toro", "Preta", "AAA-1234",
                200, false);
        veiculos[1] = new Veiculo("Toyota", "Hilux", "Prata", "BBB-1234",
                300, false);
        veiculos[2] = new Veiculo("Hyunday", "HB20", "Branca", "CCC-1234",
                100, false);
        veiculos[3] = new Veiculo("Ford", "EcoSport", "Cinza", "DDD-1234",
                150, false);
        veiculos[4] = new Veiculo("VW", "Golf", "Preto", "EEE-1234",
                250, false);
    }
    static public void cadastraCliente(Cliente[] clientes) {
        //contaCliente = 3;
        clientes[0] = (new Cliente("João", "011-1234-5678",
                "Rua um, numero 123, Vila Mimosa- São Paulo", "TORO", null));
        clientes[1] = (new Cliente("Maria", "011-3333-5432",
                "Rua dois, numero 321, Vila Cesar - São Paulo", "HB20", null));
        clientes[2] = (new Cliente("Beto", "011-2222-4563",
                "Rua vinte , numero 333, Centro - São Paulo", "GOLF", null));
        clientes[3] = (new Cliente("Jorge", "011-2212-4563",
                "Rua do cafe , numero 100, Centro - São Paulo", "HB20", null));
        clientes[4] = (new Cliente("Joaquim", "011-2222-4563",
                "Rua do Açucar , numero 2, Centro - São Paulo", "HILUX", null));
        clientes[5] = (new Cliente("Marcio", "011-2222-4563",
                "Rua do Açucar , numero 2, Centro - São Paulo", "EcoSport", null));
        clientes[6] = (new Cliente("Mario", "011-2222-4563",
                "Rua do Verde , numero 12, Centro - São Paulo", "GOLF", null));
    }
}
