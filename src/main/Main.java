<<<<<<< HEAD:src/main/Main.java
package src.main;
=======
import desconto.FormaDescontoTaxaPorBairro;
import d
>>>>>>> 11b57fede4d34f1439814a2f755c4a0cc5e4899c:Main.java

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.setValorPedido(201.0);
        pedido.setDescontoConcedido(0.0);
        pedido.setCliente(new Cliente("Ouro", "Centro"));
        pedido.addItem(new Item("Alimentação", 10.0));
        pedido.addItem(new Item("Educação", 10.0));
        pedido.addItem(new Item("Lazer", 10.0));
        FormaDescontoValorPedido descontoValorPedido = new FormaDescontoValorPedido();
        FormaDescontoTipoItem descontoTipoItem = new FormaDescontoTipoItem();
        FormaDescontoTaxaPorTipoCliente descontoTaxaPorTipoCliente = new FormaDescontoTaxaPorTipoCliente();
        FormaDescontoTaxaPorBairro descontoTaxaPorBairro = new FormaDescontoTaxaPorBairro();
        System.out.println(descontoValorPedido.calcularDesconto(pedido));
        System.out.println(descontoTipoItem.calcularDesconto(pedido));
        System.out.println(descontoTaxaPorTipoCliente.calcularDesconto(pedido));
        System.out.println(descontoTaxaPorBairro.calcularDesconto(pedido));
    }
}