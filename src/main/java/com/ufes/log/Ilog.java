package com.ufes.log;

public interface Ilog {

    public void escrever(String nomeUsuario, String data, String hora, int idPedido, String operacao, String nomeCliente);
}
