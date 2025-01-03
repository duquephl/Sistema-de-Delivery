package com.ufes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido { 
    Double taxaEntrega = 10.0;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<Item>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
    private String data;
    private String cupom;
    private int id;

    public Pedido(String data, Cliente cliente){
        this.id = new Random().nextInt(100000);
        this.data = data;
        this.cliente = cliente;
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public double getValorPedido(){
        double valorPedido = 0;
        for (Item item : itens){
            valorPedido += item.getValorTotal();
        }
        return valorPedido;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public List<Item> getItens(){
        return this.itens;
    }

    public double getTaxaEntrega(){
        return this.taxaEntrega;
    }

    public String getCupom(){
        return this.cupom;
    }

    public void setCupom(String cupom){
        this.cupom = cupom;
    }

    public int getId(){
        return this.id;
    }

    public void aplicarDescontoEntrega(CupomDescontoEntrega desconto){
        this.taxaEntrega -= desconto.getValorDesconto();
    }

    public double getDescontoConcedido(){
        double descontoConcedido = 0;
        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            descontoConcedido += cupom.getValorDesconto();
        }
        return descontoConcedido;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return this.cuponsDescontoEntrega;
    }

    public void adicionarListaCuponsDescontoEntrega(List<CupomDescontoEntrega> cupons){
        this.cuponsDescontoEntrega.addAll(cupons);
    }

    @Override
    public String toString(){
        return "Data: " + this.data + "\nCliente: " + this.cliente + "\nItens: " + this.itens + "\nTaxa de Entrega: " + this.taxaEntrega + "\nDesconto Concedido: " + this.getDescontoConcedido() + "\nValor Total: " + (this.getValorPedido() + this.taxaEntrega - this.getDescontoConcedido());
    }

}