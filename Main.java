import model.Cliente;
import model.Item;
import model.Pedido;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "ouro", .3, "Rua teste", "Centro", "Alegre");
        Pedido pedido = new Pedido("01/01/2021", cliente);
        System.out.println(pedido);
        Item item = new Item("Camisa", 50, 250., "Vestuário");
        pedido.adicionarItem(item);
        System.out.println(pedido);
        
    }
}