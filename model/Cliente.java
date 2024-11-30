package model;

public class Cliente {
    private String nome;
    private String tipo;
    private double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cliente(String nome, String tipo, Double fidelidade, String logradouro, String bairro, String cidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public void setFidelidade(Double fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getFidelidade() {
        return this.fidelidade;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String toString() {
        return "Nome: " + this.nome + "\nTipo: " + this.tipo + "\nFidelidade: " + this.fidelidade + "\nLogradouro: " + this.logradouro + "\nBairro: " + this.bairro + "\nCidade: " + this.cidade;
    }
}