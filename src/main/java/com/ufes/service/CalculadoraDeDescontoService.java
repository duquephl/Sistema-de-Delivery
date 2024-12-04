package com.ufes.service;

import java.util.ArrayList;

import com.ufes.calculos.*;
import com.ufes.model.*;

public class CalculadoraDeDescontoService{
    private ArrayList<CupomDescontoEntrega> cupons;
    private FormaDescontoTaxaPorBairro descontoBairro;
    private FormaDescontoTaxaPorTipoCliente descontoTipoCliente;
    private FormaDescontoTipoItem descontoTipoItem;
    private FormaDescontoValorPedido descontoValorPedido;

    public CalculadoraDeDescontoService(){
        this.descontoBairro = new FormaDescontoTaxaPorBairro();
        this.descontoTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        this.descontoTipoItem = new FormaDescontoTipoItem();
        this.descontoValorPedido = new FormaDescontoValorPedido();
    }

    public ArrayList<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        this.cupons = new ArrayList<>();
        this.cupons.add(this.descontoBairro.calcularDesconto(pedido));
        this.cupons.add(this.descontoTipoCliente.calcularDesconto(pedido));
        this.cupons.add(this.descontoTipoItem.calcularDesconto(pedido));
        this.cupons.add(this.descontoValorPedido.calcularDesconto(pedido));
        return cupons;
    }

}