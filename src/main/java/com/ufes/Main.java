package com.ufes;

import com.ufes.model.Cliente;
import com.ufes.model.Item;
import com.ufes.model.Pedido;
import com.ufes.service.CalculadoraDeDescontoService;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "ouro", .3, "Rua teste", "Centro", "Alegre");
        Pedido pedido = new Pedido("01/01/2021", cliente);
        Item item = new Item("Camisa", 50, 250., "lazer");
        pedido.adicionarItem(item);
        CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService();
        pedido.adicionarListaCuponsDescontoEntrega(calculadora.calcularDesconto(pedido));
        System.out.println(pedido);
    }
}