package com.tns.analizer;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;
import java.util.*;
public class BankTransactionAnalyzerSimple {

    private static final String FILE = "src/test/resources/transactions.csv";

    Path wiki_path = Paths.get(FILE);

    Charset charset = Charset.forName("ISO-8859-1");
    String datoscompletos[][];
    int monto=0,valor=0;



    public void execute() {
        try{
            System.out.println("Estamos listos para empezar!!");
            List<String> lines = Files.readAllLines(wiki_path, charset);
            conseguirMonto(lines);
            estadoPositivoNegativo();
            montoEnero(lines);
            categoriaMayorGasto(lines);

        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }

    public void conseguirMonto(List<String> lines){
            List<String> linea = lines ;


            for (String line : linea) {
                String[] datos= line.split(",");
                valor=Integer.parseInt(datos[1]);
                monto=monto+valor;
            }
            System.out.println("El monto total del archivo es " + monto);

    }

    public void estadoPositivoNegativo(){
            if(monto>0){
                System.out.println("El valor es positivo " );
            }
            else{
                System.out.println("El valor es negativo " );
            }
    }

    public void montoEnero(List<String> lines){
        List<String> linea = lines ;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try{
        Date fecha =null;
        valor=0;monto=0;

        for (String line : linea) {
            String[] datos= line.split(",");
            String fech = datos[0];
            fecha = formato.parse(fech);
            Calendar mes = Calendar.getInstance();
            mes.setTime(fecha);
            valor = Integer.parseInt(datos[1]);
            if(mes.get(Calendar.MONTH)== Calendar.JANUARY){
                monto=monto + valor;
            }

        }
        System.out.println("El monto total de enero es " + monto);
        }catch (Exception e) {

            System.out.println("Error...");
            System.out.println(e.getMessage());
    }
    }

    public void categoriaMayorGasto(List<String> lines){
        List<String> linea = lines ;
        ArrayList<String> valorcategoria =new ArrayList<String>();
        String valcategoria[][]=new String[10][1];
        int i=0;
        for (String line : linea) {
            String[] datos= line.split(",");
            String categoria=datos[2];
            int valorcate=Integer.parseInt(datos[2]) ;
            if(valorcategoria.contains(categoria)){
                valorcate=valorcate+Integer.parseInt(valcategoria[i][0]);
                valcategoria[i][0]=String.valueOf(valorcate);
                valcategoria[i][1]=categoria;
            }else{
                valcategoria[i][0]=String.valueOf(valorcate);
                valcategoria[i][1]=categoria;
            }
            i++;
        }
        String valorca = valcategoria[0][0];
        int valorNumeca =Integer.parseInt(valcategoria[0][0]);
        for (int k =1;k<10;k++){
            if (valorNumeca<Integer.parseInt(valcategoria[k][0])){
                 valorca = valcategoria[k][0];
                 valorNumeca =Integer.parseInt(valcategoria[k][0]);
            }

        }
        System.out.println("La categoria de mayor gasto es"+ valorca);

    }
}




