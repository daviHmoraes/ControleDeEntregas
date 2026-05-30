package model.entity;

public class Entrega {

    private final int id;
    private static int idPlus = 1;
    private Cliente cliente;
    private Entregador entregador;
    private String descricao;
    private StatusEntrega status;

    public Entrega(Cliente cliente, Entregador entregador, String descricao){
        setCliente(cliente);
        setEntregador(entregador);
        this.status = StatusEntrega.PENDENTE;
        this.descricao = descricao;
        this.id = idPlus++;
    }

    public int getId() { return id; }

    public int getIdPlus() { return idPlus; }

    public void setIdPlus(int idPlus) { this.idPlus = idPlus; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) {
        if(cliente == null){
            throw new RuntimeException("ERRO: o cliente não pode ser vazio.");
        } else {
            this.cliente = cliente;
        }
    }

    public Entregador getEntregador() { return entregador; }

    public void setEntregador(Entregador entregador) {
        if(entregador == null){
            throw new RuntimeException("ERRO: o entregador não pode ser vazio.");
        } else {
            this.entregador = entregador;
        }
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) {
        if(descricao.isBlank()){
            throw new RuntimeException("ERRO: a descrição não pode ser vazia.");
        } else {
            this.descricao = descricao;
        }
    }

    public StatusEntrega getStatus() { return status; }

    public void setStatus(StatusEntrega status) { this.status = status; }

}