package com.ifpb.atividadejts.controle;

import com.ifpb.atividadejts.dao.SvgDao;

import java.io.*;
import java.sql.SQLException;

public class CriaSvg {

    private SvgDao dao;

    public CriaSvg(){
        dao = new SvgDao();
    }

    public boolean criarSvg(String municipio) throws IOException, SQLException, ClassNotFoundException {

        PrintWriter writer = new PrintWriter(new FileWriter(
                                "Saida.svg", false),true);

        BufferedReader reader = new BufferedReader(
                new FileReader("Modelo.svg"));

        copiarLinhas(writer, reader, 7);

        if(dao.getPath(municipio) != null ){
            writer.println(dao.getViewBox(municipio));
        }else{
            return false;
        }

        copiarLinhas(writer, reader, 2);

        if(dao.getPath(municipio) != null ){
            writer.println(dao.getPath(municipio));
        }else{
            return false;
        }

        copiarLinhas(writer, reader, 4);

        return true;

    }

    private void copiarLinhas(PrintWriter writer, BufferedReader reader, int quant) throws IOException {

        for(int i=0;i<quant; i++){
            writer.println(reader.readLine());
        }

    }

}
