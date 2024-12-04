package com.ufes.calculos;

import com.ufes.model.CupomDescontoEntrega;
import com.ufes.model.Pedido;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega{
    private double limiteValorPedido = 200.0;
    private double valorDesconto = 5.0;
    //Existe ainda o desconto baseado no valor total do pedido. Caso o valor do pedido exceda R$ 200,00, é concedido um desconto fixo de R$ 5,00, desde que o montante de descontos já aplicados no pedido não tenha ultrapassado o limite de R$ 10,00.
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (this.seAplica(pedido)){
            System.out.println("Desconto por valor do pedido: " + this.valorDesconto);
            return new CupomDescontoEntrega("Desconto por valor do pedido", this.valorDesconto);
        }
        System.out.println("Desconto por bairro do cliente: 0");
        return new CupomDescontoEntrega("Desconto por bairro do cliente",0);
    }

    @Override
    public boolean seAplica(Pedido pedido){
        return pedido.getValorPedido() > this.limiteValorPedido && pedido.getDescontoConcedido() < 10.0;
    }
}