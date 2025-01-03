package com.ufes.calculos;

import java.util.HashMap;
import java.util.Map;

import com.ufes.model.CupomDescontoEntrega;
import com.ufes.model.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorBairroCliente;
    private String bairroCliente;    
    // R$ 2,00 para o bairro "Centro", R$ 3,00 para "Bela Vista" e R$ 1,50 para "Cidade Maravilhosa"
    public FormaDescontoTaxaPorBairro(){
        descontosPorBairroCliente = new HashMap<>();
        this.descontosPorBairroCliente.put("centro", 2.0);
        this.descontosPorBairroCliente.put("belavista", 3.0);
        this.descontosPorBairroCliente.put("cidademaravilhosa", 1.5);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por bairro do cliente", this.descontosPorBairroCliente.get(this.bairroCliente));
        }
        return new CupomDescontoEntrega("Desconto por bairro do cliente",0);
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.bairroCliente = pedido.getCliente().getBairro().toLowerCase();
        return bairroCliente.equals("centro") || bairroCliente.equals("belavista") || bairroCliente.equals("cidademaravilhosa");
    }
}