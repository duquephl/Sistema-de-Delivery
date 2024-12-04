package com.ufes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:sqlite:delivery.db");
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
