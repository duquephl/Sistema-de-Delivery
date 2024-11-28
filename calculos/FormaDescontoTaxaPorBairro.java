public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{
    private String bairroCliente;    
    // R$ 2,00 para o bairro "Centro", R$ 3,00 para "Bela Vista" e R$ 1,50 para "Cidade Maravilhosa"
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

    public boolean seAplica(Pedido pedido) {
        this.bairroCliente = pedido.getCliente().getBairro();
        if (this.bairroCliente.equals("Centro") || this.bairroCliente.equals("Bela Vista") || this.bairroCliente.equals("Cidade Maravilhosa")){
            return true;
        }
        return false;
        
    }


}