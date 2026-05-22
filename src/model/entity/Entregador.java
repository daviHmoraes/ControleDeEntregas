package model.entity;

import javax.swing.*;

public class Entregador {

    private final int id;
    private static int idContador = 1;
    private String nome;
    private String veiculo;
    private boolean disponivel;

    public Entregador(String nome, String veiculo, boolean disponivel){
        setNome(nome);
        setVeiculo(veiculo);
        setDisponivel(disponivel);
        this.id = idContador++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isBlank()){
            this.nome = nome;
        }else{
            throw new RuntimeException("ERRO: O nome nao pode ser vazio.");
        }
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        if(!veiculo.isBlank()) {
            this.veiculo = veiculo;
        }else{
            throw new RuntimeException("ERRO: O veiculo nao pode ser vazio.");
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
