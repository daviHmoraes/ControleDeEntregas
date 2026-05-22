package model.entity;

public class Cliente {

    private final int id;
    private static int idContador = 1;
    private String nome;
    private String endereco;

    public Cliente(String nome, String endereco) {
        this.id = idContador++;
        setNome(nome);
        setEndereco(endereco);
    }

    // |------------| Getter - Setter |------------|

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: Nome não pode ser vazio");
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (!endereco.isBlank()) {
            this.endereco = endereco;
        } else {
            throw new RuntimeException("ERRO: Endereço não pode ser vazio");
        }
    }

}
