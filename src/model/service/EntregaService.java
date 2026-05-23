package model.service;

import model.entity.Cliente;
import model.entity.Entrega;
import model.entity.Entregador;
import model.entity.StatusEntrega;
import model.repository.EntregaRepository;

import java.util.List;

public class EntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;
    private EntregadorService entregadorService;

    public EntregaService(EntregaRepository entregaRepository, ClienteService clienteService, EntregadorService entregadorService) {
        this.entregaRepository = entregaRepository;
        this.clienteService = clienteService;
        this.entregadorService = entregadorService;
    }

    public void salvar(int idCliente, int idEntregador, String descricao){
        Cliente cliente = clienteService.buscarPorId(idCliente);
        Entregador entregador = entregadorService.buscar(idEntregador);

        if(!entregador.isDisponivel()) {
            throw new RuntimeException("ERRO: não é possível atribuir entrega para entregador indisponível");
        }

        entregador.setDisponivel(false);

        Entrega entrega = new Entrega(cliente, entregador, descricao);
        entregaRepository.salvar(entrega);
    }

    public Entrega buscarPorId(int id){
        if(entregaRepository.buscarPorId(id) == null){
            throw new RuntimeException("ERRO: entrega não encontrada");
        } else {
            return entregaRepository.buscarPorId(id);
        }
    }

    public List<Entrega> listar(){
        List<Entrega> list = entregaRepository.listar();
        if(list.isEmpty()){
            throw new RuntimeException("ERRO: nenhuma entrega foi registrada.");
        }
        return list;
    }

    public void atualizarStatus(int idEntrega, StatusEntrega novoStatus){
        Entrega entrega = buscarPorId(idEntrega);
        StatusEntrega statusEntrega = entrega.getStatus();

        if(statusEntrega == StatusEntrega.PENDENTE && novoStatus == StatusEntrega.FINALIZADA){
            throw new RuntimeException("ERRO: não é permitido finalizar entrega que ainda está PENDENTE. Primeiro mude o status para EM_ANDAMENTO.");
        }

        if(novoStatus == StatusEntrega.FINALIZADA){
            entrega.getEntregador().setDisponivel(true);
        }

        entrega.setStatus(novoStatus);
        entregaRepository.salvar(entrega);
    }

    public void remover(int id){
        Entrega entrega = entregaRepository.buscarPorId(id);

        if(entrega.getStatus() == StatusEntrega.EM_ANDAMENTO){
            throw new RuntimeException("ERRO: não possível remover uma entrega em andamento");
        }

        if(entrega.getStatus() == StatusEntrega.FINALIZADA){
            entrega.getEntregador().setDisponivel(true);
        }

        entregaRepository.remover(id);
    }

}