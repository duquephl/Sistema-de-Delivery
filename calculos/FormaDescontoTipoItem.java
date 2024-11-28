public class FormaDescontoTipoItem implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoItem;
    private String tipoItem;
    //Para itens da categoria "Alimentação", é concedido um desconto de R$ 5,00; para itens de "Educação", o desconto é de R$ 2,00; e para itens classificados como "Lazer", o desconto corresponde a R$ 1,50.
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (this.seAplica(pedido)){
            if (this.tipoItem.equals("alimentação")){
                return new CupomDescontoEntrega("Desconto por tipo de item", 5.0);
            } else if (this.tipoItem.equals("educação")){
                return new CupomDescontoEntrega("Desconto por tipo de item", 2.0);
            } else if (this.tipoItem.equals("lazer")){
                return new CupomDescontoEntrega("Desconto por tipo de item", 1.5);
            }
        }
    }
    
    public boolean seAplica(Pedido pedido){
        this.tipoItem = pedido.getItens().getTipo().toLowerCase();
        if (this.tipoItem.equals("alimentação") || this.tipoItem.equals("educação") || this.tipoItem.equals("lazer")){
            return true;
        }
        return false;
        
    }
}
