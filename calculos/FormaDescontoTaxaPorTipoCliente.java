public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoCliente;
    private String tipoCliente;

//Clientes classificados como "Ouro" recebem R$ 3,00 de desconto, enquanto aqueles do tipo "Prata" têm direito a um desconto de R$ 2,00, e clientes "Bronze" obtêm R$ 1,00.
    public FormaDescontoTaxaPorTipoCliente(){
        
    }

    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
       
    }

    public boolean seAplica(Pedido pedido) {
        this.tipoCliente = pedido.getCliente().getTipo().toLowerCase();
        return tipoCliente.equals("ouro") || tipoCliente.equals("prata") || tipoCliente.equals("bronze");
    }
}