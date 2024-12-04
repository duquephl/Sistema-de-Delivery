package com.ufes;

import com.ufes.model.Cliente;
import com.ufes.model.Item;
import com.ufes.model.Pedido;
import com.ufes.service.CalculadoraDeDescontoService;
import com.ufes.service.LogService;
import com.ufes.service.UsuarioLogadoService;


public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "ouro", .3, "Rua teste", "Centro", "Alegre");
        Pedido pedido = new Pedido("01/01/2021", cliente);
        pedido.setCupom("DESC10");
        Item item = new Item("Camisa", 50, 250., "lazer");
        pedido.adicionarItem(item);
        CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService();
        pedido.adicionarListaCuponsDescontoEntrega(calculadora.calcularDesconto(pedido));
        LogService logService = new LogService("JSON");
        logService.registrarLog(UsuarioLogadoService.getNomeUsuario(), "01/01/2021", "10:00", pedido.getId(), "Calculo de desconto", cliente.getNome());
        LogService logService2 = new LogService("DB");
        logService2.registrarLog(UsuarioLogadoService.getNomeUsuario(), "01/01/2021", "10:00", pedido.getId(), "Calculo de desconto", cliente.getNome());
        LogService logService3 = new LogService("XML");
        logService3.registrarLog(UsuarioLogadoService.getNomeUsuario(), "01/01/2021", "10:00", pedido.getId(), "Calculo de desconto", cliente.getNome());
        System.out.println(pedido);
    }
}