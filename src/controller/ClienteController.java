package controller;

import model.entity.Cliente;
import model.service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void salvar(Cliente cliente) {
        try {
            clienteService.salvar(cliente);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente buscarPorId(int id) {
        try {
            return clienteService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cliente> listarTodos() {
        try {
            return clienteService.listarTodos();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
