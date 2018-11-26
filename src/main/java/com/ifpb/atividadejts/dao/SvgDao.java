package com.ifpb.atividadejts.dao;

import com.ifpb.atividadejts.banco.ConFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SvgDao {

    private ConFactory factory;

    public SvgDao() {
        factory = new ConFactory();
    }

    public String getViewBox(String cidade) throws SQLException, ClassNotFoundException {

        try(Connection con = factory.getConnection()){

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT getViewBoxCidade(?)");

            stmt.setString(1,cidade);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                return rs.getString(1);
            }
        }

        return null;

    }

    public String getPath(String cidade) throws SQLException, ClassNotFoundException {

        try(Connection con = factory.getConnection()){

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT ST_AsSVG(geom) FROM municipio WHERE nm_municip ilike ?");

            stmt.setString(1,cidade);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                return rs.getString(1);
            }

        }

        return null;

    }

}
