package com.ufes.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class CriarTabela {

    public static void main(String[] args) {
        var url = "jdbc:sqlite:delivery.db";

        var sql = "CREATE TABLE IF NOT EXISTS NAME ("
                //ADICIONAR
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
