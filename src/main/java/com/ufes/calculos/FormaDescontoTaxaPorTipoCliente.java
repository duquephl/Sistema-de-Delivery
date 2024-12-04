package com.ufes.calculos;

import java.util.HashMap;
import java.util.Map;

import com.ufes.model.CupomDescontoEntrega;
import com.ufes.model.Pedido;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoCliente;
    private String tipoCliente;

//Clientes classificados como "Ouro" recebem R$ 3,00 de desconto, enquanto aqueles do tipo "Prata" têm direito a um desconto de R$ 2,00, e clientes "Bronze" obtêm R$ 1,00.
    public FormaDescontoTaxaPorTipoCliente(){
        this.descontosPorTipoCliente = new HashMap<>();
        this.descontosPorTipoCliente.put("ouro", 0.3);
        this.descontosPorTipoCliente.put("prata", 0.2);
        this.descontosPorTipoCliente.put("bronze", 0.1);
        System.out.println("Descontos por tipo de cliente: " + this.descontosPorTipoCliente);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            System.out.println("Desconto por tipo de cliente: " + this.descontosPorTipoCliente.get(this.tipoCliente)* pedido.getValorPedido());
            return new CupomDescontoEntrega("Desconto por tipo de cliente", this.descontosPorTipoCliente.get(this.tipoCliente)* pedido.getValorPedido());
        }
        return new CupomDescontoEntrega("Desconto por bairro do cliente",0);
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.tipoCliente = pedido.getCliente().getTipo().toLowerCase();
        return tipoCliente.equals("ouro") || tipoCliente.equals("prata") || tipoCliente.equals("bronze");
    }
}