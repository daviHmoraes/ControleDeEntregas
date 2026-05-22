package model.repository;

import model.entity.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClienteRepository {

    private HashMap<Integer, Cliente> mapa = new HashMap<>();

    public Cliente salvar(Cliente cliente) {
        mapa.put(cliente.getId(), cliente);
        return cliente;
    }

    public Cliente buscarPorId(int id) {
        return mapa.get(id);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(mapa.values());
    }

}
