package calculos;

import java.util.HashMap;
import java.util.Map;
import model.*;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoCliente;
    private String tipoCliente;

//Clientes classificados como "Ouro" recebem R$ 3,00 de desconto, enquanto aqueles do tipo "Prata" têm direito a um desconto de R$ 2,00, e clientes "Bronze" obtêm R$ 1,00.
    public FormaDescontoTaxaPorTipoCliente(){
        this.descontosPorTipoCliente = new HashMap<>();
        this.descontosPorTipoCliente.put("ouro", 3.0);
        this.descontosPorTipoCliente.put("prata", 2.0);
        this.descontosPorTipoCliente.put("bronze", 1.0);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por tipo de cliente", this.descontosPorTipoCliente.get(this.tipoCliente));
        }
        return new CupomDescontoEntrega("Desconto por bairro do cliente",0);
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.tipoCliente = pedido.getCliente().getTipo().toLowerCase();
        return tipoCliente.equals("ouro") || tipoCliente.equals("prata") || tipoCliente.equals("bronze");
    }
}