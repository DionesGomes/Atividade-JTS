package com.ifpb.atividadejts.visao;

import com.ifpb.atividadejts.controle.CriaSvg;
import com.ifpb.atividadejts.dao.GeometryDao;
import com.ifpb.atividadejts.dao.SvgDao;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        JPEGTranscoder transcoder = new JPEGTranscoder();

        transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY,
                new Float(0.8));

        String svgURI = new File("Saida.svg").toURI().toString();

        TranscoderInput input = new TranscoderInput(svgURI);

        try {
            OutputStream ostream = new FileOutputStream("out.jpg");
            TranscoderOutput output = new TranscoderOutput(ostream);
            transcoder.transcode(input, output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TranscoderException e) {
            e.printStackTrace();
        }


    }

}
