package com.ifpb.atividadejts.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    private String url;
    private String usuario;
    private String senha;

    public ConFactory(){
        this.url = "jdbc:postgresql://localhost:5432/Brasil";
        this.usuario = "postgres";
        this.senha = "postgres";
    }

    public Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(url, usuario, senha);

    }

}
