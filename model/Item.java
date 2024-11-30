package model;

public class Item{
    String nome;
    int quantidade;
    double valorUnitario;
    String tipo;

    public Item(String nome, int quantidade, double valorUnitario, String tipo){
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public double getValorTotal(){
        return this.quantidade * this.valorUnitario;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nQuantidade: " + this.quantidade + "\nValor Unitário: " + this.valorUnitario + "\nTipo: " + this.tipo;
    }
}