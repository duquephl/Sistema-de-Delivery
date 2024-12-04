package com.ufes.service;

import java.util.ArrayList;

import com.ufes.calculos.FormaDescontoTaxaPorBairro;
import com.ufes.calculos.FormaDescontoTaxaPorCupom;
import com.ufes.calculos.FormaDescontoTaxaPorTipoCliente;
import com.ufes.calculos.FormaDescontoTipoItem;
import com.ufes.calculos.FormaDescontoValorPedido;
import com.ufes.model.CupomDescontoEntrega;
import com.ufes.model.Pedido;

public class CalculadoraDeDescontoService{
    private ArrayList<CupomDescontoEntrega> cupons;
    private FormaDescontoTaxaPorBairro descontoBairro;
    private FormaDescontoTaxaPorTipoCliente descontoTipoCliente;
    private FormaDescontoTipoItem descontoTipoItem;
    private FormaDescontoValorPedido descontoValorPedido;
    private FormaDescontoTaxaPorCupom descontoCupom;

    public CalculadoraDeDescontoService(){
        this.descontoBairro = new FormaDescontoTaxaPorBairro();
        this.descontoTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        this.descontoTipoItem = new FormaDescontoTipoItem();
        this.descontoValorPedido = new FormaDescontoValorPedido();
        this.descontoCupom = new FormaDescontoTaxaPorCupom();
    }

    public ArrayList<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        this.cupons = new ArrayList<>();
        this.cupons.add(this.descontoBairro.calcularDesconto(pedido));
        this.cupons.add(this.descontoTipoCliente.calcularDesconto(pedido));
        this.cupons.add(this.descontoTipoItem.calcularDesconto(pedido));
        this.cupons.add(this.descontoValorPedido.calcularDesconto(pedido));
        this.cupons.add(this.descontoCupom.calcularDesconto(pedido));
        return cupons;
    }

}