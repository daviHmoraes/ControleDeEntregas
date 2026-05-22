package controller;

import model.service.EntregadorService;
import model.entity.Entregador;

import java.util.List;

public class EntregadorController {

    public EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService){ this.entregadorService = entregadorService; }

    public void salvar(Entregador entregador){
        try {
            entregadorService.salvar(entregador);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Entregador buscarPorID(int id){
        try {
            return entregadorService.buscar(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Entregador> listar(){
        try {
            return entregadorService.listar();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}