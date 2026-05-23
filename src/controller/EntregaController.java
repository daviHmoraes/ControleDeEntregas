package controller;

import model.entity.Entrega;
import model.entity.StatusEntrega;
import model.service.EntregaService;
import model.service.EntregadorService;
import java.util.List;

public class EntregaController {

    private EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {this.entregaService = entregaService; }

    public void salvar(int idCliente, int idEntregador, String descricao){
        try{
            entregaService.salvar(idCliente, idEntregador, descricao);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Entrega buscarPorId(int id){
        try{
            return entregaService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Entrega> listarTodos() {
        try {
            return entregaService.listar();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void atualizarStatus(int id, StatusEntrega novoStatus){
        try{
            entregaService.atualizarStatus(id, novoStatus);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover(int id){
        try{
            entregaService.remover(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}