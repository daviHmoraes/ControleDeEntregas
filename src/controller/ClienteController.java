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
        clienteService.salvar(cliente);
    }

    public Cliente buscarPorId(int id) {
        return clienteService.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

}
