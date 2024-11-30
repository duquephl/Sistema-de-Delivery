package calculos;

import model.*;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega{
    private double limiteValorPedido = 200.0;
    private double valorDesconto = 5.0;
    //Existe ainda o desconto baseado no valor total do pedido. Caso o valor do pedido exceda R$ 200,00, é concedido um desconto fixo de R$ 5,00, desde que o montante de descontos já aplicados no pedido não tenha ultrapassado o limite de R$ 10,00.
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por valor do pedido", this.valorDesconto);
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido){
        if (pedido.getValorPedido() > this.limiteValorPedido && pedido.getDescontoConcedido() < 10.0){
            return true;
        }
        return false;
    }
}