package model.service;

import model.entity.Cliente;
import model.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public void salvar(Cliente cliente) {
        repo.salvar(cliente);
    }

    public Cliente buscarPorId(int id) {
        Cliente cliente = repo.buscarPorId(id);
        if (cliente == null) {
            throw new RuntimeException("ERRO: Cliente não encontrado");
        } else {
            return cliente;
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> list = repo.listarTodos();
        if (list.isEmpty()) {
            throw new RuntimeException("ERRO: A lista está vazia");
        } else {
            return list;
        }
    }

}
