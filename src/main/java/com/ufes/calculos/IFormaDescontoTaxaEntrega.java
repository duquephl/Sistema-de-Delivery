package com.ufes.calculos;

import com.ufes.model.*;

public interface IFormaDescontoTaxaEntrega{
    public CupomDescontoEntrega calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}