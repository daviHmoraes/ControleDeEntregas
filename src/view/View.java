package view;

import controller.ClienteController;
import controller.EntregaController;
import controller.EntregadorController;

import model.entity.Cliente;
import model.entity.Entrega;
import model.entity.Entregador;
import model.entity.StatusEntrega;

import model.repository.ClienteRepository;
import model.repository.EntregaRepository;
import model.repository.EntregadorRepository;

import model.service.ClienteService;
import model.service.EntregaService;
import model.service.EntregadorService;

import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner sc = new Scanner(System.in);

    private final ClienteRepository clienteRepository =
            new ClienteRepository();

    private final EntregadorRepository entregadorRepository =
            new EntregadorRepository();

    private final EntregaRepository entregaRepository =
            new EntregaRepository();

    private final ClienteService clienteService =
            new ClienteService(clienteRepository);

    private final EntregadorService entregadorService =
            new EntregadorService(entregadorRepository);

    private final EntregaService entregaService =
            new EntregaService(
                    entregaRepository,
                    clienteService,
                    entregadorService
            );

    private final ClienteController clienteController =
            new ClienteController(clienteService);

    private final EntregadorController entregadorController =
            new EntregadorController(entregadorService);

    private final EntregaController entregaController =
            new EntregaController(entregaService);

    public void exibirMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("===== SISTEMA DE ENTREGAS =====");

            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar entregador");
            System.out.println("3 - Cadastrar entrega");
            System.out.println("4 - Listar entregas");
            System.out.println("5 - Atualizar status");
            System.out.println("6 - Remover entrega");
            System.out.println("0 - Sair");

            try {

                System.out.print("Escolha: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        cadastrarCliente();
                        break;

                    case 2:
                        cadastrarEntregador();
                        break;

                    case 3:
                        cadastrarEntrega();
                        break;

                    case 4:
                        listarEntregas();
                        break;

                    case 5:
                        atualizarStatus();
                        break;

                    case 6:
                        removerEntrega();
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Digite um número válido.");

            } catch (RuntimeException e) {

                System.out.println(e.getMessage());
            }
        }
    }

    private void cadastrarCliente() {

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        if (nome.isBlank() || endereco.isBlank()) {

            System.out.println("Campos vazios não são permitidos.");
            return;
        }

        Cliente cliente = new Cliente(nome, endereco);

        clienteController.salvar(cliente);

        System.out.println("Cliente cadastrado.");
    }

    private void cadastrarEntregador() {

        System.out.print("Nome do entregador: ");
        String nome = sc.nextLine();

        System.out.print("Veículo: ");
        String veiculo = sc.nextLine();

        if (nome.isBlank() || veiculo.isBlank()) {

            System.out.println("Campos vazios não são permitidos.");
            return;
        }

        Entregador entregador =
                new Entregador(nome, veiculo, true);

        entregadorController.salvar(entregador);

        System.out.println("Entregador cadastrado.");
    }

    private void cadastrarEntrega() {

        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        System.out.print("ID do entregador: ");
        int idEntregador = Integer.parseInt(sc.nextLine());

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        entregaController.salvar(
                idCliente,
                idEntregador,
                descricao
        );

        System.out.println("Entrega cadastrada.");
    }

    private void listarEntregas() {

        List<Entrega> entregas =
                entregaController.listarTodos();

        if (entregas.isEmpty()) {

            System.out.println("Nenhuma entrega cadastrada.");
            return;
        }

        for (Entrega e : entregas) {

            System.out.println("\nID: " + e.getId());

            System.out.println("Cliente: " +
                    e.getCliente().getNome());

            System.out.println("Entregador: " +
                    e.getEntregador().getNome());

            System.out.println("Descrição: " +
                    e.getDescricao());

            System.out.println("Status: " +
                    e.getStatus());
        }
    }

    private void atualizarStatus() {

        System.out.print("ID da entrega: ");
        int idEntrega = Integer.parseInt(sc.nextLine());

        System.out.println("1 - Pendente");
        System.out.println("2 - Em andamento");
        System.out.println("3 - Finalizada");

        int opcao = Integer.parseInt(sc.nextLine());

        StatusEntrega status = null;

        switch (opcao) {

            case 1:
                status = StatusEntrega.PENDENTE;
                break;

            case 2:
                status = StatusEntrega.EM_ANDAMENTO;
                break;

            case 3:
                status = StatusEntrega.FINALIZADA;
                break;

            default:
                System.out.println("Status inválido.");
                return;
        }

        entregaController.atualizarStatus(
                idEntrega,
                status
        );

        System.out.println("Status atualizado.");
    }

    private void removerEntrega() {

        System.out.print("ID da entrega: ");
        int id = Integer.parseInt(sc.nextLine());

        entregaController.remover(id);

        System.out.println("Entrega removida.");
    }
}