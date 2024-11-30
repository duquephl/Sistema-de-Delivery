package src.calculos;

import src.model.CupomDescontoEntrega;
import src.model.Pedido;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorBairroCliente;
    private String bairroCliente;    
<<<<<<< HEAD:src/calculos/FormaDescontoTaxaPorBairro.java
    @Override
=======
    // R$ 2,00 para o bairro "Centro", R$ 3,00 para "Bela Vista" e R$ 1,50 para "Cidade Maravilhosa"
    public FormaDescontoTaxaPorBairro(){
        this.descontosPorBairroCliente = new HashMap<String, Double>();
        this.descontosPorBairroCliente.put("Centro", 2.0);
        this.descontosPorBairroCliente.put("Bela Vista", 3.0);
        this.descontosPorBairroCliente.put("Cidade Maravilhosa", 1.5);
    }

>>>>>>> 11b57fede4d34f1439814a2f755c4a0cc5e4899c:calculos/FormaDescontoTaxaPorBairro.java
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por bairro do cliente", this.descontosPorBairroCliente.get(this.bairroCliente));
        }
        
    }
    
    @Override
    public boolean seAplica(Pedido pedido) {
        this.bairroCliente = pedido.getCliente().getBairro().toLowerCase();
        return bairroCliente.equals("centro") || bairroCliente.equals("belavista") || bairroCliente.equals("cidademaravilhosa");
    }
}