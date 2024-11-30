package calculos;

import java.util.Map;
import model.CupomDescontoEntrega;
import model.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorBairroCliente;
    private String bairroCliente;    
    // R$ 2,00 para o bairro "Centro", R$ 3,00 para "Bela Vista" e R$ 1,50 para "Cidade Maravilhosa"
    public FormaDescontoTaxaPorBairro(){
        this.descontosPorBairroCliente.put("centro", 2.0);
        this.descontosPorBairroCliente.put("belavista", 3.0);
        this.descontosPorBairroCliente.put("cidademaravilhosa", 1.5);
        System.out.println("Descontos por bairro: " + this.descontosPorBairroCliente);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por bairro do cliente", this.descontosPorBairroCliente.get(this.bairroCliente));
        }
        return null;
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.bairroCliente = pedido.getCliente().getBairro().toLowerCase();
        return bairroCliente.equals("centro") || bairroCliente.equals("belavista") || bairroCliente.equals("cidademaravilhosa");
    }
}