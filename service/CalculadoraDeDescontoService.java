package service;

import calculos.FormaDescontoTaxaPorBairro;
import calculos.FormaDescontoTaxaPorTipoCliente;
import calculos.FormaDescontoTipoItem;
import calculos.FormaDescontoValorPedido;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class CalculadoraDeDescontoService{
    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        List<CupomDescontoEntrega> cupons = new ArrayList<>();
        FormaDescontoTaxaPorBairro descontoBairro = new FormaDescontoTaxaPorBairro();
        FormaDescontoTaxaPorTipoCliente descontoTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        FormaDescontoTipoItem descontoTipoItem = new FormaDescontoTipoItem();
        FormaDescontoValorPedido descontoValorPedido = new FormaDescontoValorPedido();
        cupons.add(descontoBairro.calcularDesconto(pedido));
        cupons.add(descontoTipoCliente.calcularDesconto(pedido));
        cupons.add(descontoTipoItem.calcularDesconto(pedido));
        cupons.add(descontoValorPedido.calcularDesconto(pedido));
        return cupons;
    }

}