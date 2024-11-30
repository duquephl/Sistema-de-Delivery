package src.calculos;

import java.util.Map;

import src.model.*;

public class FormaDescontoTipoItem implements IFormaDescontoTaxaEntrega{
    private Map<String, Double> descontosPorTipoItem;
    private String tipoItem;
<<<<<<< HEAD:src/calculos/FormaDescontoTipoItem.java
    @Override
=======
    //Para itens da categoria "Alimentação", é concedido um desconto de R$ 5,00; para itens de "Educação", o desconto é de R$ 2,00; e para itens classificados como "Lazer", o desconto corresponde a R$ 1,50.
    public FormaDescontoTipoItem(){
        this.descontosPorTipoItem = new HashMap<String, Double>();
        this.descontosPorTipoItem.put("alimentação", 5.0);
        this.descontosPorTipoItem.put("educação", 2.0);
        this.descontosPorTipoItem.put("lazer", 1.5);
    }

>>>>>>> 11b57fede4d34f1439814a2f755c4a0cc5e4899c:calculos/FormaDescontoTipoItem.java
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (this.seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto por tipo de item", this.descontosPorTipoItem.get(this.tipoItem));
        }
        return null;
    }
    @Override
    public boolean seAplica(Pedido pedido){
        for (Item item : pedido.getItens()){
            this.tipoItem = item.getTipo().toLowerCase();
            if (this.tipoItem.equals("alimentação") || this.tipoItem.equals("educação") || this.tipoItem.equals("lazer")){
                return true;
            }
        }
        return false;
        
    }
}