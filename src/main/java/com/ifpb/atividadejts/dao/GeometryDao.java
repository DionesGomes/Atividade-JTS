package com.ifpb.atividadejts.dao;

import com.ifpb.atividadejts.banco.ConFactory;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeometryDao {

    public ConFactory factory;
    public WKTReader reader;

    public GeometryDao(){
        factory = new ConFactory();
        reader = new WKTReader();
    }

    public Geometry getGeometriaCidade(String cidade)
            throws SQLException, ClassNotFoundException,
            ParseException {

        String wkt = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT ST_AsEWKT(geom)" +
                            "FROM municipio" +
                            " WHERE nm_municip ilike ?"
            );

            stmt.setString(1, cidade);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                wkt = rs.getString(1);
            }
        }

        if(wkt !=null){
            return reader.read(wkt);
        }else {
            return null;
        }

    }

}
