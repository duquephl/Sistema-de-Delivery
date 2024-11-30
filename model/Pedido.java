package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido { 
    Double taxaEntrega = 10.0;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<Item>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<CupomDescontoEntrega>();
    private String data;

    public Pedido(String data, Cliente cliente){
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

    @Override
    public String toString(){
        return "Data: " + this.data + "\nCliente: " + this.cliente + "\nItens: " + this.itens + "\nTaxa de Entrega: " + this.taxaEntrega + "\nDesconto Concedido: " + this.getDescontoConcedido();
    }

}