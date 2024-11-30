import model.Cliente;
import model.Item;
import model.Pedido;
import service.CalculadoraDeDescontoService;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "ouro", .3, "Rua teste", "Centro", "Alegre");
        Pedido pedido = new Pedido("01/01/2021", cliente);
        Item item = new Item("Camisa", 50, 250., "lazer");
        pedido.adicionarItem(item);
        CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService();
        calculadora.calcularDesconto(pedido);
        System.out.println(pedido);
    }
}