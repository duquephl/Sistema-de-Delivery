package com.ufes.service;

import com.ufes.log.DBLog;
import com.ufes.log.Ilog;
import com.ufes.log.JSONLog;
import com.ufes.log.XMLLog;

public class LogService {
    private Ilog logStrategy;

    public LogService(String tipoLog) {
        // Define o tipo de log com base na escolha (JSON, XML, DB)
        if (tipoLog.equalsIgnoreCase("JSON")) {
            this.logStrategy = new JSONLog();
        } else if (tipoLog.equalsIgnoreCase("XML")) {
            this.logStrategy = new XMLLog();
        } else if (tipoLog.equalsIgnoreCase("DB")) {
            this.logStrategy = new DBLog();
        }
    }

    public void registrarLog(String nomeUsuario, String data, String hora, int idPedido, String operacao, String nomeCliente) {
        logStrategy.escrever(nomeUsuario, data, hora, idPedido, operacao, nomeCliente);
    }
}
