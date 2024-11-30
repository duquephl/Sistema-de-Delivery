package src.calculos;

import src.model.CupomDescontoEntrega;
import src.model.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{
    private String bairroCliente;    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)) {
            /// @TODO: Implementação Duvidoza
            if (this.bairroCliente.equals("Centro")){
                return new CupomDescontoEntrega("Desconto por bairro", 2.0);
            } else if (this.bairroCliente.equals("Bela Vista")){
                return new CupomDescontoEntrega("Desconto por bairro", 3.0);
            } else if (this.bairroCliente.equals("Cidade Maravilhosa")){
                return new CupomDescontoEntrega("Desconto por bairro", 1.5);
            }
        }
        return null;
        
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.bairroCliente = pedido.getCliente().getBairro();
        if (this.bairroCliente.equals("Centro") || this.bairroCliente.equals("Bela Vista") || this.bairroCliente.equals("Cidade Maravilhosa")){
            return true;
        }
        return false;
        
    }
}