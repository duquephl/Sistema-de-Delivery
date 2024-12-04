package com.ufes.log;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JSONLog implements Ilog {
    @Override
    public void escrever(String nomeUsuario, String data, String hora, int idPedido, String operacao, String nomeCliente) {
        JSONObject log = new JSONObject();
        log.put("nomeUsuario", nomeUsuario);
        log.put("data", data);
        log.put("hora", hora);
        log.put("idPedido", idPedido);
        log.put("operacao", operacao);
        log.put("nomeCliente", nomeCliente);

        try (FileWriter file = new FileWriter("log.json", true)) {
            file.write(log.toString(4) + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }
}
