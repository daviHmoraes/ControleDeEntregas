package model.service;

import model.entity.Entregador;
import model.repository.EntregadorRepository;

import java.util.ArrayList;
import java.util.List;

public class EntregadorService {

    private EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository){this.entregadorRepository = entregadorRepository;}

    public void salvar(Entregador entregador){
        entregadorRepository.salvar(entregador);
    }

    public Entregador buscar(int id) {
        Entregador entregador = entregadorRepository.buscarPorID(id);
        if(entregador == null) {
            throw new RuntimeException("ERRO: Entregador não encontrado.");
        } else {
            return entregador;
        }
    }

    public List<Entregador> listar(){
        List<Entregador> list = entregadorRepository.listar();
        if(list.isEmpty()) {
            throw new RuntimeException("ERRO: A lista está vazia");
        } else {
            return list;
        }
    }

}