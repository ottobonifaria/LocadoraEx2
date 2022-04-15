import controller.ClienteController;
import controller.RelatorioController;
import controller.VeiculoController;
import domain.Cliente;
import domain.Relatorio;
import domain.Veiculo;

import java.util.*;
public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String menu;
        Cliente[] clientes = new Cliente[7];
        ClienteController clienteController = new ClienteController();

        Veiculo[] veiculos = new Veiculo[10];
        VeiculoController veiculoController = new VeiculoController();

        Relatorio[] relatorios = new Relatorio[100];
        RelatorioController relatorioController = new RelatorioController();

        Queue<Cliente> filaEspera = new ArrayDeque<>();


        do {
            exibirMenu();
            menu = sc.next();
            switch (menu) {
                case "1":
                    System.out.println("====== Cadastrando Veiculo");
                    veiculoController.cadastra(veiculos); //cadastra 10 veiculos para ter um inicio
                    break;
                case "2":
                    System.out.println("\n===== FIFTCARS ===== \n Confira nossos modelos\n");
                    System.out.println("=====> LISTA DE VEICULOS CADASTRADO <=====");
                    veiculoController.listarVeiculos(veiculos);
                    break;
                case "3":
                    System.out.println("CADASTRANDO CLIENTE");
                    clienteController.cadastraCliente(clientes); //Cadastra 7 Clientes para ter um inicio
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
                    System.out.println("===== CADASTRA LISTA DE ESPERA =====");
                    clienteController.addListaDeEspera(filaEspera,clientes);
                    break;
                case "8":
                    System.out.println("=============FILA DE ESPERA==============");
                    relatorioController.imprimeFilaDeEspera(filaEspera);
                    break;
                case "9":
                    //Aluga veiculo para o primeiro da lista de espera
                    veiculoController.emprestarCarro(filaEspera, clientes,veiculos);
                    break;
                case "10":
                    System.out.println("DEVOLUÇÃO");
                    veiculoController.devolverCarro(filaEspera,clientes,veiculos);
                    break;
                case "11":
                    System.out.println("RELATÓRIO DE LOCAÇÃO");
                    //relatorioController.imprimeHistorico(veiculos,clientes,relatorios, veiculoController.contaHistorico);
                    veiculoController.relatorioLocação();
                    break;
                case "12":
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while(menu !="12");
    }
    static public void exibirMenu() {
        System.out.println("===================== LOCADORA ============================\n");
        System.out.println(" 1 - CADASTRAR VEICULOS   |   2 - LISTAR VEICULOS CADASTRADOS");
        System.out.println(" 3 - CADASTRAR CLIENTES   |   4 - LISTAR CLIENTES CADASTRADOS");
        System.out.println(" 5 - ORDENAR MENOR VALOR  |   6 - CONSULTA VEICULO DISPONIVEL PARA ALUGAR");
        System.out.println(" 7 - CRIA LISTA DE ESPERA |   8 - CONSULTA LISTA DE ESPERA");
        System.out.println(" 9 - ALUGA VEICULO        |  10 - DEVOLUÇÃO DE VEICULO");
        System.out.println("11 - RELATORIO DE LOCAÇÃO |  ");
        System.out.println("                     12 - SAIR");


    }
}
