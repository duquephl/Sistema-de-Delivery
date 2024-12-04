package com.ufes.calculos;

import java.util.HashMap;
import java.util.Map;

import com.ufes.model.CupomDescontoEntrega;
import com.ufes.model.Pedido;

public class FormaDescontoTaxaPorCupom implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorCupom;
    private String cupom;

//Clientes classificados como "Ouro" recebem R$ 3,00 de desconto, enquanto aqueles do tipo "Prata" têm direito a um desconto de R$ 2,00, e clientes "Bronze" obtêm R$ 1,00.
    public FormaDescontoTaxaPorCupom(){
        this.descontosPorCupom = new HashMap<>();
        this.descontosPorCupom.put("DESC10", 0.1);
        this.descontosPorCupom.put("DESC20", 0.2);
        this.descontosPorCupom.put("DESC30", 0.3);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por tipo de cliente", this.descontosPorCupom.get(pedido.getCupom())* pedido.getValorPedido());
        }
        return new CupomDescontoEntrega("Desconto por tipo de cliente", 0);
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.cupom = pedido.getCupom();
        return this.descontosPorCupom.containsKey(this.cupom);
    }
}
