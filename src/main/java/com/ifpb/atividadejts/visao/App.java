package com.ifpb.atividadejts.visao;

import com.ifpb.atividadejts.dao.GeometryDao;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        GeometryDao dao = new GeometryDao();

        Geometry geom1 = null;
        Geometry geom2 = null;

        try{
            geom1 = dao.getGeometriaCidade("Cajazeiras");
            geom2 = dao.getGeometriaCidade("Uiraúna");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(geom1 != null && geom2 != null){

            System.out.println("Área 1: "+geom1.getArea()*
                    Math.pow((40075/360),2)+" km^2");

            System.out.println("Perímetro 1: "+geom1.getLength()
                *(40075/360)+" km");

            System.out.println("Área 2: "+geom2.getArea()*
                    Math.pow((40075/360),2)+" km^2");

            System.out.println("Distância: "+
                geom1.getCentroid().distance(geom2.getCentroid())
                        *(40075/360)+ "km");

            System.out.println("Vizinhos? "+geom1
                    .touches(geom2));



        }

    }

}
