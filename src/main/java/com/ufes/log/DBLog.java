package com.ufes.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBLog implements Ilog {
    private static final String URL = "jdbc:sqlite:log.db";

    public DBLog() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nomeUsuario TEXT NOT NULL," +
                     "data TEXT NOT NULL," +
                     "hora TEXT NOT NULL," +
                     "idPedido INTEGER NOT NULL," +
                     "operacao TEXT NOT NULL," +
                     "nomeCliente TEXT NOT NULL" +
                     ");";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public void escrever(String nomeUsuario, String data, String hora, int idPedido, String operacao, String nomeCliente) {
        String sql = "INSERT INTO logs (nomeUsuario, data, hora, idPedido, operacao, nomeCliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, data);
            pstmt.setString(3, hora);
            pstmt.setInt(4, idPedido);
            pstmt.setString(5, operacao);
            pstmt.setString(6, nomeCliente);
            pstmt.executeUpdate();

            System.out.println("Log gravado no banco de dados com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao gravar log no banco de dados: " + e.getMessage());
        }
    }
}
